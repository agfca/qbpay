package qb.llrj.pay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qb.llrj.pay.dao.RoleMenuDao;
import qb.llrj.pay.model.RoleMenu;
import qb.llrj.pay.service.RoleMenuService;

/**
 * @ClassName:			RoleMenuServiceImpl
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月7日  下午3:02:44
 */
@Service
@Transactional
public class RoleMenuServiceImpl implements RoleMenuService {
	
	@Autowired
	private RoleMenuDao dao;
	
	@Override
	public int insert(RoleMenu record) {
		return dao.insert(record);
	}

	@Override
	public int updateByPrimaryKey(RoleMenu record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer roleMenuId) {
		return dao.deleteByPrimaryKey(roleMenuId);
	}

	@Override
	public RoleMenu selectByPrimaryKey(Integer roleMenuId) {
		return dao.selectByPrimaryKey(roleMenuId);
	}

	@Override
	public List<RoleMenu> findAll() {
		return dao.findAll();
	}

	@Override
	public List<RoleMenu> findByRoleId(Integer roleId) {
		return dao.findByRoleId(roleId);
	}

	@Override
	public int delByRoleId(Integer roleId) {
		return dao.delByRoleId(roleId);
	}
}


