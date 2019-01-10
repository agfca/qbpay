package qb.llrj.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qb.llrj.pay.model.Client;
import qb.llrj.pay.service.ClientInfoService;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * company
 * client 注册
 */
@Controller
@RequestMapping("/companyRegister")
public class CompanyRegisterController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ClientInfoService clientInfoService;

	/**判断用户是否存在 TODO */
	private boolean exist(String username){
		//Client client = clientInfoService.findByName(username);
		Client client = new Client();
		//return (client !=null);
		return false;
	}
	/**加密密码  TODO */
	private String encryptPassword(String pwd){
		//pwd = new BCryptPasswordEncoder().encode(pwd);
		return pwd;
	}

	//TODO 验证 email 合格
	private boolean verifyEmail(String email){
		return true;
	}

	@RequestMapping("/emailIsOrNotExist.htm")
	@ResponseBody
	public Map<String,String> emailIsOrNotExist(@RequestParam String userEmail){
		Map<String,String> map = new HashMap<>();
		map.put("valid","false");
		if(!exist(userEmail))
			map.put("valid","true");
		return map;
	}

	//提交
	@RequestMapping("/index.htm")
	public String index(HttpServletRequest request
			,String userEmail	//电子邮箱
			,String password	//登录面=密码
			,String payPassword	//支付密码
			,String coopName	//公司名称
			,String	siteName		//网站名称
			,String siteURL	//网址
			//,String userName	//负责人名字
			,String userTel		//负责人电话
	){
		String errMsg = "";
		String result = "false";

		request.setAttribute("userEmail",userEmail);
		request.setAttribute("password",password);
		request.setAttribute("payPassword",payPassword);
		request.setAttribute("coopName",coopName);
		request.setAttribute("siteURL",siteURL);
		request.setAttribute("siteName",siteName);
		//request.setAttribute("userName",userName);
		request.setAttribute("userTel",userTel);

		String url = "register/companyRegister";		//1.注册账号
		if(userEmail!=null){
			if(!verifyEmail(userEmail)){		//2.校验邮箱是否合格
				request.setAttribute("errMsg","电子邮箱不合格");
			}else if(exist(userEmail)) {       //3.判断邮箱是已经注册
				request.setAttribute("errMsg","电子邮箱已经注册");
			}else{								//4.填写密码
				url = "register/companyRegisterPassword";
				if(password!=null&&payPassword!=null){
					if(password.length()<6||payPassword.length()<6){
						request.setAttribute("errMsg","密码不能小于6位");
					}else if(password.equals(payPassword)){//密码相同
						request.setAttribute("errMsg","支付密码和登录密码不能相同");
					}else{						//5.填写信息

						url = "register/companyRegisterDetail";
						//userName!=null
						if(coopName!=null&&siteURL!=null&&siteName!=null&&userTel!=null){
												//6.信息填写完毕

							if(coopName.length()<=1){//公司名称
								request.setAttribute("errMsg","请确认公司名称");
							}
							if(siteURL.length()<=1){
								request.setAttribute("errMsg","请确认网站名称");
							}
							if(siteName.length()<=1){
								request.setAttribute("errMsg","请检查网址");
							}
							/*if(userName!=null&&userName.length()<=1){
								request.setAttribute("errMsg","请检查业务负责人");
							}*/
							if(userTel.length()<=1){
								request.setAttribute("errMsg","请检查业务负责人电话");
							}
							if(request.getAttribute("errMsg")==null){//注册成功
								//TODO 添加用户信息

								url = "register/companyRegisterSuccess";
							}
						}

					}
				}

			}
		}
		return url;
	}

}
