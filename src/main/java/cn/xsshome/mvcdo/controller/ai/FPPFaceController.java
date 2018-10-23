package cn.xsshome.mvcdo.controller.ai;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xsshome.mvcdo.common.AIConstant;
import cn.xsshome.mvcdo.pojo.ai.fpp.dbo.FPPFaceDO;
import cn.xsshome.mvcdo.service.ai.fpp.FPPFaceService;
import cn.xsshome.mvcdo.util.PageUtils;
import cn.xsshome.mvcdo.util.Query;
import cn.xsshome.mvcdo.util.WholeResponse;
/**
 * 
 * @author 小帅丶
 * @date 2018年10月10日
 * <p>Description: 肤质分析管理模块</p>
 */
@Controller
@RequestMapping(value="/fpp")
@Scope("prototype")
public class FPPFaceController {
	private static Logger logger = LoggerFactory.getLogger(FPPFaceController.class);
	@Autowired
	private FPPFaceService fppFaceService;
	/**
	 * 跳转肤质分析管理页面 
	 * @param request request对象
	 * @param response response对象
	 * @return 页面
	 */
	@RequestMapping(value="/indexFPPFace")
	public String indexFPPFace(HttpServletRequest request,HttpServletResponse response){
		logger.info("index跳转肤质分析管理页面");
		return "ai/fpp/skinface";
	}
	/**
	 * 加载肤质分析识别数据
	 * @param params
	 * @return
	 */
	@ResponseBody
	@GetMapping("/listFPPFace")
	public PageUtils listFPPFace(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<FPPFaceDO> detectDOs = fppFaceService.listFPPFace(query);
		int total = fppFaceService.countFPPFace(query);
		PageUtils pageUtils = new PageUtils(detectDOs, total);
		return pageUtils;
	}
	/**
	 * 删除
	 */
	@PostMapping("/removeFPPFace")
	@ResponseBody
	public WholeResponse removeFPPFace(Long id,HttpServletRequest request,HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			if (AIConstant.DEMO_ACCOUNT.equals(session.getAttribute("username"))) {
				return WholeResponse.errorResponse("1", "测试账户不允许添加数据");
			}
			if (fppFaceService.removeFPPFace(id) > 0) {
				return WholeResponse.successResponse("删除成功");
			}
		} catch (Exception e) {
			logger.error("remove肤质分析出错"+e.getMessage());
			return WholeResponse.errorResponse("500", "系统异常");
		}
		return null;
	}
	/**
	 * 批量删除
	 */
	@PostMapping("/batchRemoveFPPFace")
	@ResponseBody
	public WholeResponse batchRemoveFPPFace(@RequestParam("ids[]") Long[] fppId,HttpServletRequest request,HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			if (AIConstant.DEMO_ACCOUNT.equals(session.getAttribute("username"))) {
				return WholeResponse.errorResponse("1", "测试账户不允许添加数据");
			}
			fppFaceService.batchRemoveFPPFace(fppId);
			return WholeResponse.successResponse("批量删除成功");
		} catch (Exception e) {
			logger.error("批量删除肤质分析出错"+e.getMessage());
			return WholeResponse.errorResponse("500", "系统异常");
		}
	}
}
