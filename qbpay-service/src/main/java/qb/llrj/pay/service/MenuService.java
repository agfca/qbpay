package qb.llrj.pay.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import qb.llrj.pay.model.Menu;

/**
 * @ClassName:			MenuService
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月4日  下午4:48:23
 */
public interface MenuService {
	
	int insert(Menu record);
	
	int updateByPrimaryKey(Menu record);
	
	int deleteByPrimaryKey(Integer menuId);
	
	Menu selectByPrimaryKey(Integer menuId);
	
	List<Menu> findAll();
	
	/**
	 * 查询所有的父菜单
	 * menuType 0前端 1后台 2公共  null全部
	 * @return
	 */
	List<Menu> findAllParent(Integer menuType);
	
	/**
	 * 查询子菜单
	 * @param menuParentId
	 * @return
	 */
	List<Menu> findMenuByParentId(Integer menuParentId);
	
	/**
	 * 开启关闭某个父菜单下的所有子菜单
	 * @param menuParentId
	 * @return
	 */
	int editMenuStatuByParentId(Integer menuParentId,Integer menuStatu);
	
	/**
	 * 调整父菜单的 type时 子菜单跟着一起变
	 * @param menuParentId
	 * @param menuType
	 * @return
	 */
	int editMenuTypeByParentId(Integer menuParentId,Integer menuType);
	
	/**
	 * 根据主菜单批量删除子菜单
	 * @param menuParentId
	 * @return
	 */
	int delMenuByParentId(Integer menuParentId);
	
	/**
	 * 查询所有前端或后台可用的菜单   
	 * @param menuType 0前端 1后台  （公用部分已经包括）
	 * @return
	 */
	List<Menu> findMenuByMenuType(@Param("menuType")Integer menuType);
}


