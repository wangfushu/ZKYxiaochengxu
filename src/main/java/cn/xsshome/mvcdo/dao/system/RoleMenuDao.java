package cn.xsshome.mvcdo.dao.system;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.xsshome.mvcdo.pojo.system.RoleMenuDO;


/**
 * 角色与菜单对应关系
 * @author 福淑
 *
 */
@Mapper
public interface RoleMenuDao {

	RoleMenuDO get(Long id);
	
	List<RoleMenuDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(RoleMenuDO roleMenu);
	
	int update(RoleMenuDO roleMenu);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	List<Long> listMenuIdByRoleId(Long roleId);
	
	int removeByRoleId(Long roleId);
	
	int batchSave(List<RoleMenuDO> list);
}
