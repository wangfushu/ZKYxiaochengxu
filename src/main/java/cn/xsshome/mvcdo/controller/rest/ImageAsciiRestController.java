package cn.xsshome.mvcdo.controller.rest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.xsshome.mvcdo.common.AIConstant;
import cn.xsshome.mvcdo.util.PrintUtil;
import cn.xsshome.mvcdo.util.QQSendEmailUtil;
import cn.xsshome.mvcdo.util.imageprocess.ImageToChar;
import cn.xsshome.mvcdo.vo.BDConstant;
import cn.xsshome.mvcdo.vo.BDDishResponse;
import cn.xsshome.mvcdo.vo.ImageAsciiResponse;
import cn.xsshome.mvcdo.vo.RestResponse;

import com.alibaba.fastjson.JSON;
/**
 * 图片转字符图片
 * @author 小帅丶
 * @date 2018年8月14日
 * <p>Description:图片转字符图片 </p>
 */
@Controller
@RequestMapping(value="rest/ias")
@Scope("prototype")
public class ImageAsciiRestController {
	private static Logger logger = LoggerFactory.getLogger(ImageAsciiRestController.class);
	/**
	 * 图片转字符文本接口
	 * @param file
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/image2ascii",method={RequestMethod.POST})
	public void uoloadFaceMerge(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		String resultData = "";	
		String clientType = request.getParameter("clientType");
		logger.info("=======访问的IP"+request.getRemoteAddr()+"======访问的User-Agent:"+request.getHeader("User-Agent"));
		logger.info("=======访问的类型"+clientType); 
		try {
			if(!clientType.equals("wsc")){
				 BDDishResponse bdDishResponse = new BDDishResponse();
				 bdDishResponse.setCode(BDConstant.BD_403.getCode().toString());
				 bdDishResponse.setMsg("缺少必要参数");
                resultData = JSON.toJSONString(bdDishResponse);
                logger.info("=====接口返回的内容:"+resultData);
                PrintUtil.printJson(response,resultData);
			}else{
				String authCode = request.getParameter("authCode");
				if(null==authCode||!authCode.equals(AIConstant.AUTH_CODE)){
					RestResponse restResponse = new BDDishResponse();
					restResponse.setCode(BDConstant.BD_NOTFUND.getCode().toString());
					restResponse.setMsg(BDConstant.BD_NOTFUND.getMsg());
                    resultData = JSON.toJSONString(restResponse);
                    logger.info("=====接口返回的内容:"+resultData);
                    PrintUtil.printJson(response,resultData);
				}else{
					byte[] imageByte = file.getBytes();
					InputStream inputStream = new ByteArrayInputStream(imageByte);
					BufferedImage bufferedImage = ImageIO.read(inputStream);
					String imageBase64 = ImageToChar.txtToImageByBase64(bufferedImage);
					if(imageBase64.equals("")||null==imageBase64){
						RestResponse restResponse = new BDDishResponse();
						restResponse.setCode(BDConstant.BD_ERROR.toString());
						restResponse.setMsg("图片转字符图片失败了");
	                    resultData = JSON.toJSONString(restResponse);
	                    QQSendEmailUtil.send_email("图片转字符文本接口错误警报", "接口返回内容：\n"+resultData+"\n访问接口的ip："+request.getRemoteAddr(), AIConstant.EMAIL_ADDRESS);
	                    PrintUtil.printJson(response,resultData);
					}else{
						ImageAsciiResponse asciiResponse = new ImageAsciiResponse();
						asciiResponse.setCode(BDConstant.BD_SUCCESS.getCode().toString());
						asciiResponse.setMsg(BDConstant.BD_SUCCESS.getMsg());
						asciiResponse.setImage(imageBase64);
						resultData = JSON.toJSONString(asciiResponse);
						PrintUtil.printJson(response, resultData);
					}
				}
			}
		} catch (Exception e) {
			logger.info("图片转字符文本接口出错了"+e.getMessage());
			RestResponse restResponse = new BDDishResponse();
			restResponse.setCode(BDConstant.BD_ERROR.getCode().toString());
			restResponse.setMsg(BDConstant.BD_ERROR.getMsg());
            resultData = JSON.toJSONString(restResponse);
            System.out.println(resultData);
            PrintUtil.printJson(response,resultData);
		}
	}
}
