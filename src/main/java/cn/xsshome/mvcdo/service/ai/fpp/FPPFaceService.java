package cn.xsshome.mvcdo.service.ai.fpp;

import java.util.List;
import java.util.Map;

import cn.xsshome.mvcdo.pojo.ai.fpp.dbo.FPPFaceDO;


/**
 * 
 * @author 小帅丶
 * @date 2018年10月10日
 * <p>Description: 肤质分析interface</p>
 */
public interface FPPFaceService {
	List<FPPFaceDO> listFPPFace(Map<String, Object> map);
	int countFPPFace(Map<String,Object> map);
	int saveFPPFace(FPPFaceDO fppFaceDO);
	int removeFPPFace(Long fppId);
	int batchRemoveFPPFace(Long[] fppIds);
	FPPFaceDO getFPPFace(String faceToken);
}
