package cn.xsshome.mvcdo.service.ai.fpp.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xsshome.mvcdo.dao.ai.fpp.FPPFaceDao;
import cn.xsshome.mvcdo.pojo.ai.fpp.dbo.FPPFaceDO;
import cn.xsshome.mvcdo.service.ai.fpp.FPPFaceService;
/**
 * 
 * @author 小帅丶
 * @date 2018年10月10日
 * <p>Description: 肤质分析</p>
 */
@Service
public class FPPFaceServiceImpl implements FPPFaceService{
	@Autowired
	FPPFaceDao fppFaceMapper;
	@Override
	public List<FPPFaceDO> listFPPFace(Map<String, Object> map) {
		return fppFaceMapper.listFPPFace(map);
	}

	@Override
	public int countFPPFace(Map<String, Object> map) {
		return fppFaceMapper.countFPPFace(map);
	}

	@Override
	public int saveFPPFace(FPPFaceDO fppFaceDO) {
		return fppFaceMapper.saveFPPFace(fppFaceDO);
	}

	@Override
	public int removeFPPFace(Long fppId) {
		return fppFaceMapper.removeFPPFace(fppId);
	}

	@Override
	public int batchRemoveFPPFace(Long[] fppIds) {
		return fppFaceMapper.batchRemoveFPPFace(fppIds);
	}

	@Override
	public FPPFaceDO getFPPFace(String faceToken) {
		return fppFaceMapper.getFPPFace(faceToken);
	}

}
