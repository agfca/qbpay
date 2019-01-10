package qb.llrj.pay.service;

import java.util.List;

import qb.llrj.pay.model.Role;

/**
 * @ClassName:			RoleService
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月7日  下午2:49:34
 */
public interface RoleService {
	
	int insert(Role record);
	
	int updateByPrimaryKey(Role record);
	
	int deleteByPrimaryKey(Integer roleId);
	
	Role selectByPrimaryKey(Integer roleId);
	
	List<Role> findAll();
	
	/**
	 * 根据客户查询角色
	 * @param clientId
	 * @return
	 */
	List<Role> findRoleByclientId(Integer clientId);
}


