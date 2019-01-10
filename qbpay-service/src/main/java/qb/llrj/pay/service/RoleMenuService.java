package qb.llrj.pay.service;

import java.util.List;

import qb.llrj.pay.model.RoleMenu;

/**
 * @ClassName:			RoleMenuService
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月7日  下午2:56:49
 */
public interface RoleMenuService {
	
	int insert(RoleMenu record);
	
	int updateByPrimaryKey(RoleMenu record);
	
	int deleteByPrimaryKey(Integer roleMenuId);
	
	RoleMenu selectByPrimaryKey(Integer roleMenuId);
	
	List<RoleMenu> findAll();	
	
	/**
	 * 根据角色查询菜单信息
	 * @param roleId
	 * @return
	 */
	List<RoleMenu> findByRoleId(Integer roleId);
	
	/**
	 * 根据角色删除配置的菜单
	 * @param roleId
	 * @return
	 */
	int delByRoleId(Integer roleId);
}


