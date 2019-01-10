package qb.llrj.pay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import qb.llrj.pay.model.Menu;
import qb.llrj.pay.service.MenuService;

/**
 * @ClassName:			MenuController
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月4日  下午4:53:24
 */

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired 
	private MenuService menuService;
	
	@RequestMapping("/index.htm")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/menuIndex.htm")
	public String menuIndex(){
		return "menuControl";
	}
	
	JSONObject res = new JSONObject();
	
	@RequestMapping("/loadAllMenu.htm")
	@ResponseBody
	public List<Menu> loadAllMenu(){
		List<Menu> menus = null;
		try {
			menus = menuService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}
	
	@RequestMapping("/addOrEditMenu.htm")
	@ResponseBody
	public JSONObject addOrEditMenu(Menu menu){
		try {
			if(menu.getMenuId() != null){
				if(menu.getMenuParentId() == 0){
					menuService.editMenuStatuByParentId(menu.getMenuId(), menu.getMenuStatu());
					menuService.editMenuTypeByParentId(menu.getMenuId(), menu.getMenuType());
				}
				menuService.updateByPrimaryKey(menu);
			}else{
				menuService.insert(menu);
			}
			res.put("statu", true);
			res.put("msg", "操作成功");
		} catch (Exception e) {
			res.put("statu", false);
			res.put("msg", "系统错误");
			e.printStackTrace();
		}
		return res;
	}
	
	@RequestMapping("/loadParentMenu.htm")
	@ResponseBody
	public List<Menu> loadParentMenu(){
		List<Menu> menus = null;
		try {
			menus = menuService.findAllParent(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}
	
	@RequestMapping("/loadChildMenu.htm")
	@ResponseBody
	public List<Menu> loadChildMenu(Integer menuId){
		List<Menu> menus = null;
		try {
			menus = menuService.findMenuByParentId(menuId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}
	
	@RequestMapping("/editMenuStatu.htm")
	@ResponseBody
	public JSONObject editMenuStatu(Integer menuId,Integer menuStatu){
		try {
			Menu menu = menuService.selectByPrimaryKey(menuId);
			if(menu != null){
				if(menu.getMenuLevel() == 0){
					menuService.editMenuStatuByParentId(menuId, menuStatu);
				}
				menu.setMenuStatu(menuStatu);
				menuService.updateByPrimaryKey(menu);
				res.put("statu", true);
				res.put("msg", "操作成功");
			}else{
				res.put("statu", false);
				res.put("msg", "操作失败，菜单验证错误");
			}
		} catch (Exception e) {
			res.put("statu", false);
			res.put("msg", "系统错误");
			e.printStackTrace();
		}
		return res;
	}
	
	@RequestMapping("/delMenu.htm")
	@ResponseBody
	public JSONObject delMenu(Integer menuId){
		try {
			Menu menu = menuService.selectByPrimaryKey(menuId);
			if(menu != null){
				if(menu.getMenuLevel() != 0){
					menuService.delMenuByParentId(menuId);
				}
				menuService.deleteByPrimaryKey(menuId);
				res.put("statu", true);
				res.put("msg", "操作成功");
			}else{
				res.put("statu", false);
				res.put("msg", "操作失败，菜单验证错误");
			}
		} catch (Exception e) {
			res.put("statu", false);
			res.put("msg", "系统错误");
			e.printStackTrace();
		}
		return res;
	}
}


