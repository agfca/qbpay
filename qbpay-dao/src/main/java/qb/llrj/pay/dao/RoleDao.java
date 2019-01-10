package qb.llrj.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import qb.llrj.pay.model.Role;

/**
 * @ClassName:			RoleDao
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月4日  上午11:03:20
 */
@Repository
public interface RoleDao {
	
	int insert(Role record);
	
	int updateByPrimaryKey(Role record);
	
	int deleteByPrimaryKey(@Param("roleId")Integer roleId);
	
	Role selectByPrimaryKey(@Param("roleId")Integer roleId);
	
	List<Role> findAll();
	
	/**
	 * 根据客户查询角色
	 * @param clientId
	 * @return
	 */
	List<Role> findRoleByclientId(@Param("clientId")Integer clientId);
}


