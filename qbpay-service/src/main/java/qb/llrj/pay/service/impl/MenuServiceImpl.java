package qb.llrj.pay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qb.llrj.pay.dao.MenuDao;
import qb.llrj.pay.model.Menu;
import qb.llrj.pay.service.MenuService;

/**
 * @ClassName:			MenuServiceImpl
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月4日  下午4:51:58
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao dao;
	
	@Override
	public int insert(Menu record) {
		if(record.getMenuParentId() == null || record.getMenuParentId() == 0){
			record.setMenuLevel(0);
		}else{
			record.setMenuLevel(1);
		}
		return dao.insert(record);
	}

	@Override
	public int updateByPrimaryKey(Menu record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer menuId) {
		return dao.deleteByPrimaryKey(menuId);
	}

	@Override
	public Menu selectByPrimaryKey(Integer menuId) {
		return dao.selectByPrimaryKey(menuId);
	}

	@Override
	public List<Menu> findAll() {
		return dao.findAll();
	}
	
	@Override
	public List<Menu> findAllParent(Integer menuType) {
		return dao.findAllParent(menuType);
	}

	@Override
	public List<Menu> findMenuByParentId(Integer menuParentId) {
		return dao.findMenuByParentId(menuParentId);
	}

	@Override
	public int editMenuStatuByParentId(Integer menuParentId, Integer menuStatu) {
		return dao.editMenuStatuByParentId(menuParentId, menuStatu);
	}

	@Override
	public int delMenuByParentId(Integer menuParentId) {
		return dao.delMenuByParentId(menuParentId);
	}

	@Override
	public int editMenuTypeByParentId(Integer menuParentId, Integer menuType) {
		return dao.editMenuTypeByParentId(menuParentId, menuType);
	}

	@Override
	public List<Menu> findMenuByMenuType(Integer menuType) {
		return dao.findMenuByMenuType(menuType);
	}
}


