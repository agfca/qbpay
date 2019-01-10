package qb.llrj.pay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qb.llrj.pay.dao.RoleDao;
import qb.llrj.pay.model.Role;
import qb.llrj.pay.service.RoleService;

/**
 * @ClassName:			RoleServiceImpl
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月7日  下午2:50:04
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao dao;
	
	@Override
	public int insert(Role record) {
		record.setRoleStatu(0);
		record.setRoleJurisdiction(0);
		return dao.insert(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer roleId) {
		return dao.deleteByPrimaryKey(roleId);
	}

	@Override
	public Role selectByPrimaryKey(Integer roleId) {
		return dao.selectByPrimaryKey(roleId);
	}

	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Role> findRoleByclientId(Integer clientId) {
		return dao.findRoleByclientId(clientId);
	}

}


