package qb.llrj.pay.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import qb.llrj.pay.model.RoleMenu;

/**
 * @ClassName:			RoleMenuDao
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月4日  上午11:04:21
 */
@Repository
public interface RoleMenuDao {
	
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


