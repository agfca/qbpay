package qb.llrj.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import qb.llrj.pay.model.Client;
import qb.llrj.pay.model.Menu;
import qb.llrj.pay.model.PayBanksOffers;
import qb.llrj.pay.model.Role;
import qb.llrj.pay.model.RoleMenu;
import qb.llrj.pay.service.ClientInfoService;
import qb.llrj.pay.service.MenuService;
import qb.llrj.pay.service.RoleMenuService;
import qb.llrj.pay.service.RoleService;
import qb.llrj.pay.util.Md5Util;
import qb.llrj.pay.util.MySpaceUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * client 注册
 */
@Controller
@RequestMapping("/userRegister")
public class UserRegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientInfoService clientInfoService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RoleMenuService roleMenuService;

	//接口方法：验证手机号码
	@RequestMapping("/CheckPhoneIsExit.htm")
	@ResponseBody
	public Map<String,String>  CheckPhoneIsExit(String clientPhone,Integer id){
		Map<String,String> res = new HashMap<>();
		try 
		{
			if(clientPhone==null||clientPhone.length()==0){
				res.put("valid", "true");
				return res;
			}
			if(id==null){
				id=0;
			}
			Map<String,Object> map = new HashMap<>();
			map.put("clientPhone", clientPhone);
			map.put("id", id);
			Client m=clientInfoService.selectByPhone(map);
			if(m!=null){
				res.put("valid", "false");
			}else{
				res.put("valid", "true");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	//接口方法：验证身份证号码是否已经存在
		@RequestMapping("/CheckUnifiedCodeIsExit.htm")
		@ResponseBody
		public Map<String,String>  CheckUnifiedCodeIsExit(String unifiedCode,Integer id){
			Map<String,String> res = new HashMap<>();
			try 
			{
				if(unifiedCode==null || unifiedCode.isEmpty()){
					res.put("valid", "true");
					return res;
				}
				if(id==null){
					id=0;
				}
				Map<String,Object> map = new HashMap<>();
				map.put("socialUnifiedCode", unifiedCode);
				map.put("id", id);
				
				Client m=clientInfoService.selectByUnifiedCode(map);
				if(m!=null){
					res.put("valid", "false");
				}else{
					res.put("valid", "true");
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return res;
		}
	
	//个人注册：注册页面
	@RequestMapping("/index.htm")
	public ModelAndView index(){
		return new ModelAndView("register/userRegister");
	}
			
	//个人注册：注册提交
	@RequestMapping("/RegisterSubmit.htm")
	@ResponseBody
	public JSONObject RegisterSubmit(
			HttpServletRequest request
			,@RequestParam String 	clientPhone			//手机号码
			,@RequestParam String 	password			//登录密码
			,@RequestParam String 	paypassword			//支付密码
			,@RequestParam String 	clientName			//真实姓名
			,@RequestParam String 	socialUnifiedCode	//身份证号码
			,@RequestParam String 	socialCodeStartDate	//身份证开始日期
			,@RequestParam String 	socialCodeEndDate	//身份证结束日期
			,@RequestParam Integer 	socialCodeDateState	//身份证日期是否长期有效,0：临时， 1：长期 
			
			,@RequestParam Integer 	clientProvinceId	//省份ID
			,@RequestParam String 	clientProvinceTxt	//省份文本
			,@RequestParam Integer 	clientCityId		//城市ID
			,@RequestParam String 	clientCityTxt		//城市文本
			,@RequestParam Integer 	clientAreaId		//区域ID
			,@RequestParam String 	clientAreaTxt		//区域文本
			,@RequestParam String 	clientAddress		//常驻地址	
	)
	{
		JSONObject json=new JSONObject();
		try{
			if(clientPhone==null||clientPhone.length()==0){
				json.put("Result", false);
				json.put("Msg", "手机号不能为空");
				return json;
			}
			if(password==null||password.length()==0){
				json.put("Result", false);
				json.put("Msg", "登录密码不能");
				return json;
			}
			if(paypassword==null||paypassword.length()==0){
				json.put("Result", false);
				json.put("Msg", "支付密码不能");
				return json;
			}
			
			if(clientName==null||clientName.length()==0){
				json.put("Result", false);
				json.put("Msg", "用户名称不能为空");
				return json;
			}
			if(socialUnifiedCode==null||socialUnifiedCode.length()==0){
				json.put("Result", false);
				json.put("Msg", "身份证号码不能为空");
				return json;
			}
			Map<String,Object> map = new HashMap<>();
			map.put("clientPhone", clientPhone);
			map.put("id", 0);
			
			
			Client m=clientInfoService.selectByPhone(map);
			if(m!=null){
				json.put("Result", false);
				json.put("Msg", "手机号码已注册，请更换");
				return json;
			}
			map.put("socialUnifiedCode", socialUnifiedCode);
			m=clientInfoService.selectByUnifiedCode(map);
			if(m!=null){
				json.put("Result", false);
				json.put("Msg", "身份证号码已经存在，请更换");
				return json;
			}
			
			Client model=new Client();
			model.setClientName(clientName);
			model.setClientPhone(clientPhone);
			
			String md5_pwd=Md5Util.MD5Encode(password, "utf-8");			//登录密码加密
			String md5_paypwd=Md5Util.MD5Encode(paypassword, "utf-8");	//支付密码加密
			model.setPassword(md5_pwd);
			model.setPayPassword(md5_paypwd);
			
			model.setSocialUnifiedCode(socialUnifiedCode);
			model.setClientCodeStartDate(MySpaceUtil.stringToDate(socialCodeStartDate,"yyyy-MM-dd"));
			model.setClientCodeEndDate(MySpaceUtil.stringToDate(socialCodeEndDate,"yyyy-MM-dd"));
			model.setClientCodeDateState(socialCodeDateState);
			
			
			model.setClientProvinceId(clientProvinceId);
			model.setClientProvinceTxt(clientProvinceTxt);
			model.setClientCityId(clientCityId);
			model.setClientCityTxt(clientCityTxt);
			model.setClientAreaId(clientAreaId);
			model.setClientAreaTxt(clientAreaTxt);
			model.setClientAddress(clientAddress);
			model.setCreateTime(new Date());	//创建日期
			model.setClientStatus(1);					//默认状态是正常的
			model.setParentid(0);						//默认注册为主账户
			model.setClientType(1);						//用户类型：1：用户注册  2：企业注册
			model.setUserStatus(0);					//客户状态，1：正常 0：禁用 
			
			//该分配角色
			Role role = new Role();
			role.setRoleName("管理员");
			role.setRoleJurisdiction(1);
			role.setRoleRemark("管理员");
			role.setRoleStatu(0);
			roleService.insert(role);
			
			model.setRoleId(role.getRoleId());
			
			//分配权限
			List<Menu> menusPublic = menuService.findMenuByMenuType(0);
			for (Menu menu : menusPublic) {
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setRoleId(role.getRoleId());
				roleMenu.setMenuId(menu.getMenuId());
				roleMenuService.insert(roleMenu);
			}
			
			if(clientInfoService.insertModel(model)){
				
				role.setClientId(model.getId());
				roleService.updateByPrimaryKey(role);
				
				json.put("Result", true);
				json.put("Msg", "注册成功");
				
			}else{
				json.put("Result", false);
				json.put("Msg", "注册失败");
			}
		}
		catch(Exception e){
			json.put("Result", false);
			json.put("Msg", "异常错误,发生在用户注册时");
			System.out.println(e.getMessage());
		}
		return json;
	}
//

	//个人注册：注册成功
	@RequestMapping("Success.htm")
	public ModelAndView regbyuserok(HttpServletRequest request){
		ModelAndView model=new ModelAndView("register/userRegisterSuccess");
		//逻辑验证登录信息
		if(false){
			model=new  ModelAndView("redirect:/register/userRegister");
		}
		return model;
	}
			
	//个人登录页面
	@RequestMapping("/login.htm")
	public ModelAndView userLogin(HttpServletRequest request){
		ModelAndView model=new ModelAndView("login/userLogin");
		return model;
	}
	
	//个人登录接口
	@RequestMapping("/loginSubmit.htm")
	@ResponseBody
	public JSONObject userLoginSubmit(HttpSession session,@RequestParam String 	clientPhone,@RequestParam String 	password){
		JSONObject json=new JSONObject();
		try{
			if(clientPhone==null||clientPhone.isEmpty()){
				json.put("Result", false);
				json.put("Msg", "登录失败,手机号码不能为空");
				return json;
			}
			if(password==null||password.isEmpty()){
				json.put("Result", false);
				json.put("Msg", "登录失败, 登录密码不能为空");
				return json;
			}			
			Map<String,Object> map = new HashMap<>();
			map.put("clientPhone", clientPhone);
			map.put("id", 0);
			Client m=clientInfoService.selectByPhone(map);
			if(m==null){
				json.put("Result", false);
				json.put("Msg", "登录失败, 登录密码不能为空");
				return json;
			}else
			{
				String md5_pwd = Md5Util.MD5Encode(password, "utf-8");	//登录密码加密
				if(m.getPassword().equals(md5_pwd)==false){//登录失败
					json.put("Result", false);
					json.put("Msg", "登录失败, 请确认账户或密码是否正确");
					return json;
				}
					json.put("Result", true);
					json.put("Msg", "登录成功");
					json.put("url", "role/index.htm");
					
					// 登录成功后查询用户所有的权限
					List<RoleMenu> roleMenus = roleMenuService.findByRoleId(m.getRoleId());
					// 获取全部菜单
					List<Menu> menus = menuService.findAll();

					// 用于保存用户菜单
					List<Menu> menu = new ArrayList<>();

					// 过滤用户菜单
					for (Menu item : menus) {
						for (RoleMenu roleMenu : roleMenus) {
							if (roleMenu.getMenuId() == item.getMenuId()) {
								menu.add(item);
							}
						}
					}
					session.setAttribute("user", m);
					session.setAttribute("menus", menu);
		}
			
		}catch(Exception e){
			json.put("Result", false);
			json.put("Msg", "异常错误，发生在登录时");
			System.out.println(e.getMessage());
		}
		return json;
	}
}
