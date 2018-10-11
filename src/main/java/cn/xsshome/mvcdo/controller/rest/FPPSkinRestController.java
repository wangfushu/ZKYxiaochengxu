package cn.xsshome.mvcdo.controller.rest;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.xsshome.mvcdo.common.AIConstant;
import cn.xsshome.mvcdo.pojo.ai.fpp.dbo.FPPFaceDO;
import cn.xsshome.mvcdo.pojo.ai.fpp.po.FacePPSkinBean;
import cn.xsshome.mvcdo.service.ai.fpp.FPPFaceService;
import cn.xsshome.mvcdo.util.FileUtil;
import cn.xsshome.mvcdo.util.PrintUtil;
import cn.xsshome.mvcdo.util.QQSendEmailUtil;
import cn.xsshome.mvcdo.vo.BDConstant;
import cn.xsshome.mvcdo.vo.FPPFaceResponse;
import cn.xsshome.taip.http.HttpUtil;
/**
 * 
 * @author 小帅丶
 * @date 2018年10月9日
 * <p>Description:肤质分析 </p>
 */
@Controller
@RequestMapping(value="rest/fpp")
@Scope("prototype")
public class FPPSkinRestController {
	private static final String API_KEY = "";//应用apikey
	private static final String API_SECRET = "";//应用apisecret
	private static final String FACE_DETECT_URL = "https://api-cn.faceplusplus.com/facepp/v3/detect";//人脸检测接口地址
	private static Logger logger = LoggerFactory.getLogger(FPPSkinRestController.class);
	@Autowired
	FPPFaceService fppFaceService;
	/**
	 * 肤质分析
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	 @RequestMapping(value = "/detect",method = {RequestMethod.POST})
	 public String uploadFaceSkin(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, Exception{
		 	SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
		    String resultData = "";	
			String clientType = request.getParameter("clientType");
	        String openId = ServletRequestUtils.getStringParameter(request, "openId","");
	        String nickName = ServletRequestUtils.getStringParameter(request, "nickName","");
			logger.info("=======访问的IP"+request.getRemoteAddr()+"======访问的User-Agent:"+request.getHeader("User-Agent"));
			logger.info("=======访问的类型"+clientType); 
	        if(null==clientType||null==clientType){
	        	FPPFaceResponse faceResponse = new FPPFaceResponse();
	        	faceResponse.setCode(BDConstant.BD_NULL.getCode().toString());
	        	faceResponse.setMsg(BDConstant.BD_NULL.getMsg());
	            resultData = JSON.toJSONString(faceResponse);
	            logger.info("=====接口响应页面的内容:"+resultData);
	            PrintUtil.printJson(response,resultData);
	        }else{
	        	String perfix = "fppFaceSkin/";
	            String dbPath ="/"+perfix;
	            String fileName = "fppFace"+new Date().getTime()/1000+FileUtil.fileType(file.getOriginalFilename());
	            String filePath = request.getSession().getServletContext().getRealPath(perfix);
	            logger.info("=======保存的路径"+filePath+"/"+fileName);
	        try {
	        	nickName = URLEncoder.encode(nickName, "UTF-8");
	        	if(clientType.equals("web")){
					if(null==request.getHeader("User-Agent")){
						FPPFaceResponse faceResponse = new FPPFaceResponse();
						faceResponse.setCode(BDConstant.BD_403.getCode().toString());
						faceResponse.setMsg(BDConstant.BD_403.getMsg());
		                 resultData = JSON.toJSONString(faceResponse);
		                 logger.info("=====接口响应页面的内容:"+resultData);
		                 PrintUtil.printJson(response,resultData);
					}else{
						FPPFaceResponse faceResponse = new FPPFaceResponse();
						faceResponse.setCode(BDConstant.BD_NOTFUND.getCode().toString());
						 faceResponse.setMsg(BDConstant.BD_NOTFUND.getMsg());
		                 resultData = JSON.toJSONString(faceResponse);
		                 logger.info("=====接口响应页面的内容:"+resultData);
		                 PrintUtil.printJson(response,resultData);
					}
				}else if (clientType!=null&&clientType.equals("wsc")) {
					String authCode = request.getParameter("authCode");
	            	if(null==authCode||!authCode.equals(AIConstant.AUTH_CODE)){
	            		FPPFaceResponse faceResponse = new FPPFaceResponse();
	            		faceResponse.setCode(BDConstant.BD_NOTFUND.getCode().toString());
	            		faceResponse.setMsg(BDConstant.BD_NOTFUND.getMsg());
	                    resultData = JSON.toJSONString(faceResponse);
	                    logger.info("=====接口响应页面的内容:"+resultData);
	                    PrintUtil.printJson(response,resultData);
	            	}
				}
				FileUtil.uploadFile(file.getBytes(),filePath,fileName);
				System.out.println("end====="+new Date().getTime());
				 //图片的本地路径
	            String imagePath = filePath+fileName;
	            HashMap<String, String> option = new HashMap<String, String>();
	            option.put("detect_direction", "true");
	            dbPath += fileName;
	            resultData = getFPPFaceResult(imagePath);
	            logger.info("FPP接口返回="+resultData);
	            FacePPSkinBean skinBean = JSON.parseObject(resultData, FacePPSkinBean.class);
	            if(null==skinBean){
	            	FPPFaceResponse faceResponse = new FPPFaceResponse();
	            	faceResponse.setCode(BDConstant.BD_ERROR.getCode().toString());
	            	faceResponse.setMsg(BDConstant.BD_ERROR.getMsg());
	            	resultData = JSON.toJSONString(faceResponse);
	            	QQSendEmailUtil.send_email("FPP接口错误", 
	            			"接口返回内容："+resultData+"\n"+"UserAgent:"+request.getHeader("User-Agent")+"\n"+"访问IP："+request.getRemoteAddr()+"\n"+"微信昵称："+URLDecoder.decode(nickName, "UTF-8"), 
	            			AIConstant.EMAIL_ADDRESS);
	            	 PrintUtil.printJson(response,resultData);
	            }else{
	            	if(skinBean.getFaces().size()<=0){
	            		FPPFaceResponse faceResponse = new FPPFaceResponse();
	            		faceResponse.setCode(BDConstant.BD_NOFACE.getCode().toString());
	            		faceResponse.setMsg(BDConstant.BD_NOFACE.getMsg());
		            	resultData = JSON.toJSONString(faceResponse);
		            	QQSendEmailUtil.send_email("FPP接口无结果异常", 
		            			"接口返回内容："+resultData+"\n"+"UserAgent:"+request.getHeader("User-Agent")+"\n"+"访问IP："+request.getRemoteAddr()+"\n"+"微信昵称："+URLDecoder.decode(nickName, "UTF-8"), 
		            			AIConstant.EMAIL_ADDRESS);
		            	 PrintUtil.printJson(response,resultData);
	            	}else{
	            		FPPFaceResponse faceResponse = new FPPFaceResponse();
	            		faceResponse.setCode(BDConstant.BD_SUCCESS.getCode().toString());
	            		faceResponse.setMsg(BDConstant.BD_SUCCESS.getMsg());
	            		BigDecimal health = new BigDecimal(skinBean.getFaces().get(0).getAttributes().getSkinstatus().getHealth()).setScale(0, BigDecimal.ROUND_HALF_UP);
	            		BigDecimal stain = new BigDecimal(skinBean.getFaces().get(0).getAttributes().getSkinstatus().getStain()).setScale(0, BigDecimal.ROUND_HALF_UP);
	            		BigDecimal acne = new BigDecimal(skinBean.getFaces().get(0).getAttributes().getSkinstatus().getAcne()).setScale(0, BigDecimal.ROUND_HALF_UP);
	            		BigDecimal darkCircle = new BigDecimal(skinBean.getFaces().get(0).getAttributes().getSkinstatus().getDark_circle()).setScale(0, BigDecimal.ROUND_HALF_UP);
	            		faceResponse.setHealth(health+"");
	            		faceResponse.setStain(stain+"");
	            		faceResponse.setAcne(acne+"");
	            		faceResponse.setDarkCircle(darkCircle+"");
	            		resultData = JSON.toJSONString(faceResponse);
	            		FPPFaceDO fppFaceDODB = fppFaceService.getFPPFace(skinBean.getFaces().get(0).getFace_token());
	            		if(null==fppFaceDODB){
	            			FPPFaceDO fppFaceDO = new FPPFaceDO();
		            		fppFaceDO.setFaceToken(skinBean.getFaces().get(0).getFace_token());
		            		fppFaceDO.setGender(skinBean.getFaces().get(0).getAttributes().getGender().getValue());
		            		fppFaceDO.setAge(skinBean.getFaces().get(0).getAttributes().getAge().getValue());
		            		fppFaceDO.setSkinHealth(health+"");
		            		fppFaceDO.setSkinStain(stain+"");
		            		fppFaceDO.setSkinAcne(acne+"");
		            		fppFaceDO.setSkinDarkCircle(darkCircle+"");
		            		fppFaceDO.setOpenId(openId);
		            		fppFaceDO.setNikeName(nickName);
		            		fppFaceDO.setImagePath(dbPath);
		            		fppFaceDO.setApiType("skin");
		            		fppFaceDO.setEnterType(clientType);
		            		fppFaceDO.setDetectDate(format.format(new Date()));
		            		fppFaceService.saveFPPFace(fppFaceDO);
	            		}else{
	            			QQSendEmailUtil.send_email("FPP接口相同faceToken", 
			            			"接口返回内容："+resultData+"\n"+"UserAgent:"+request.getHeader("User-Agent")+"\n"+"访问IP："+request.getRemoteAddr()+"\n"+"微信昵称："+URLDecoder.decode(nickName, "UTF-8"), 
			            			AIConstant.EMAIL_ADDRESS);
	            		}
	            		PrintUtil.printJson(response,resultData);
	            	}
	            }
			} catch (Exception e) {
				logger.info("FPP接口出错了"+e.getMessage());
		      	QQSendEmailUtil.send_email("FPP接口错误", 
            			"异常信息："+e.getMessage()+"\n"+"接口返回内容："+resultData+"\n"+"UserAgent:"+request.getHeader("User-Agent")+"\n"+"访问IP："+request.getRemoteAddr()+"\n"+"微信昵称："+URLDecoder.decode(nickName, "UTF-8"), 
            			AIConstant.EMAIL_ADDRESS);
				FPPFaceResponse faceResponse = new FPPFaceResponse();
				faceResponse.setCode(BDConstant.BD_ERROR.getCode().toString());
				faceResponse.setMsg(BDConstant.BD_ERROR.getMsg());
	            resultData = JSON.toJSONString(faceResponse);
	            logger.info("FPP接口出错响应="+resultData);
	            PrintUtil.printJson(response,resultData);
			}
	    }
		return null;
	 }
	/**
	 * 接口返回的内容 
	 * @param imagePath
	 * @return
	 * @throws Exception
	 */
	private String getFPPFaceResult(String imagePath) throws Exception {
		Encoder base64Encoder = Base64.getEncoder();
		String image_base64 = base64Encoder.encodeToString(FileUtil.readFileByBytes(imagePath));
		String return_attributes = "gender,age,smiling,headpose,facequality,blur,eyestatus,emotion,ethnicity,beauty,mouthstatus,eyegaze,skinstatus";
		String params = "api_key="+API_KEY+"&api_secret="+API_SECRET+"&image_base64="+URLEncoder.encode(image_base64,"utf-8")+"&return_attributes="+return_attributes;
		String result = HttpUtil.post(FACE_DETECT_URL, params);
		return result;
	}
}
