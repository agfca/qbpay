package qb.llrj.pay;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import qb.llrj.pay.model.Client;
import qb.llrj.pay.model.Menu;
import qb.llrj.pay.model.Role;
import qb.llrj.pay.model.RoleMenu;
import qb.llrj.pay.service.MenuService;
import qb.llrj.pay.service.RoleMenuService;
import qb.llrj.pay.service.RoleService;

/**
 * @ClassName:			RoleController
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月7日  下午2:44:50
 */
 @Controller
 @RequestMapping("/role")
public class RoleController {
	 
	 @Autowired
	 private RoleService roleService;
	 
	 @Autowired
	 private RoleMenuService roleMenuService;
	 
	 @Autowired
	 private MenuService menuService;
	 
	 JSONObject res = new JSONObject();
	 JSONArray resArr = new JSONArray();
	 
	 @RequestMapping("/index.htm")
	 public String index(){
		 return "index";
	 }
	 
	 @RequestMapping("/roleIndex.htm")
	 public String roleIndex(){
		 return "roleControl";
	 }
	 
	 @RequestMapping("/loadRole.htm")
	 @ResponseBody
	 public List<Role> loadRole(HttpSession session){
		 List<Role> roles = new ArrayList<Role>();
		 try {
			 Client client = (Client) session.getAttribute("user");
			 roles = roleService.findRoleByclientId(client.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return roles;
	 }
	 
	 @RequestMapping("/addOrEditRole.htm")
	 @ResponseBody
	 public JSONObject addOrEditRole(HttpSession session,Role role){
		 Client client = (Client) session.getAttribute("user");
		 try {
			 if(role.getRoleId() != null){
				 Role r = roleService.selectByPrimaryKey(role.getRoleId());
				 r.setRoleName(role.getRoleName());
				 r.setRoleRemark(role.getRoleRemark());
				 roleService.updateByPrimaryKey(r);
			 }else{
				 role.setClientId(client.getId());
				 roleService.insert(role);
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
	 
	 @RequestMapping("/delRole.htm")
	 @ResponseBody
	 public JSONObject delRole(Integer roleId){
		 try {
			 
			 roleMenuService.delByRoleId(roleId);
			 
			 roleService.deleteByPrimaryKey(roleId);
			 
			 res.put("statu", true);
			 res.put("msg", "操作成功");
		} catch (Exception e) {
			res.put("statu", false);
			res.put("msg", "系统错误");
			e.printStackTrace();
		}
		 return res;
	 }
	 
	 @RequestMapping("/loadRoleMenu.htm")
	 @ResponseBody
	 public JSONArray loadRoleMenu(Integer roleId){
		 resArr = new JSONArray();
		 try {
			//查询可用菜单
			List<Menu> menus = menuService.findMenuByMenuType(0);
			//查询角色所拥有的权限
			List<RoleMenu> roleMenus = roleMenuService.findByRoleId(roleId);
			
			for (Menu m : menus) {
				JSONObject obj  = new JSONObject();
				obj.put("id", m.getMenuId());
				obj.put("pId", m.getMenuParentId());
				obj.put("name", m.getMenuName());
				obj.put("open", "true");
				for (RoleMenu roleMenu : roleMenus) {
					if(roleMenu.getMenuId() == m.getMenuId()){
						obj.put("checked", "true");
					}
				}
				resArr.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return resArr;
	 }
	 
	 //获取当前账户下(主账户)的创建的角色
	 @RequestMapping("/loadClientMenu.htm")
	 @ResponseBody
	 public JSONArray loadClientMenu(HttpSession session){
		 JSONArray jsonlist = new JSONArray();
		 try{
			 Client client = (Client) session.getAttribute("user");
			 if(client==null || client.getId()==0){
				 return jsonlist;
			 }
			 List<Role> list= roleService.findRoleByclientId(client.getId());
			 for(Role m:list){
				 JSONObject obj  = new JSONObject();
				 obj.put("Id", m.getRoleId());
				 obj.put("Name", m.getRoleName());
				 jsonlist.add(obj);
			 }
		 }catch (Exception e) {
			 e.printStackTrace();
		}
		 return jsonlist;
	 }
	 @RequestMapping("/roleMenuChange.htm")
	 @ResponseBody
	 public JSONObject roleMenuChange(Integer roleId,String menuId){
		 try {
			 roleMenuService.delByRoleId(roleId);
			 
			 RoleMenu roleMenu = null;
			 
			 String[] menuIds = menuId.split(",");
			 for (String string : menuIds) {
				 roleMenu = new RoleMenu();
				 roleMenu.setRoleId(roleId);
				 roleMenu.setMenuId(Integer.parseInt(string));
				 roleMenuService.insert(roleMenu);
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
}


