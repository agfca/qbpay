package qb.llrj.pay;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.scripting.xmltags.VarDeclSqlNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import qb.llrj.pay.model.PayBanksOffers;
 
/**
 * @ClassName: ExtendController
  */
@Controller
@RequestMapping("/account")
public class AccountController  {

	//
	@RequestMapping("/login.htm")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mav=new ModelAndView("login");
		return mav;
	}
	
	//个人注册：注册页面
	@RequestMapping("/regbyuser.htm")
	public ModelAndView RegisterByUser(HttpServletRequest request){
		ModelAndView m=new ModelAndView("regbyuser");
		
		Object phonestateObj=request.getAttribute("phonestate");		//手机号码验证
		Object substateObj=request.getAttribute("substate");//个人注册状态
		
		String phonestate=phonestateObj==null?"":phonestateObj.toString();
		String substate=substateObj==null?"0":substateObj.toString();
		
		if(!phonestate.isEmpty()){
			System.out.println(phonestate);
			m=new ModelAndView("regbyuserinfo");//填写详细信息
		}
//		if(!substate.isEmpty()){
//			System.out.println(substate);
//			m=new ModelAndView("regbyuserok");	//注册成功
//		}
		return m;
	}
	
	//个人注册1:手机号码验证（接口）
	@RequestMapping("/regbyusercheck.htm")
	public String regbyusercheck(HttpServletRequest request){
		//业务逻辑处理
		request.setAttribute("phonestate", "17774977753");
		String reString = "forward:regbyuser.htm";
		return reString;
	}
	
	//个人注册2:提交册详细信息（接口）
	@RequestMapping("/regbyusersub.htm")
	public String regbyusersub(HttpServletRequest request,PayBanksOffers model){
		
		//个人注册成功
		request.removeAttribute("phonestate");
		request.setAttribute("substate","1");
		String reString = "forward:regbyuser.htm";
		return reString;
		
//		JSONObject json = new JSONObject();
//		
//		try {
//			String string=request.getParameter("companyName");
//			json.put("Result", true);
//			json.put("Msg", "操作成功");
//		}
//		catch(Exception e)
//		{
//			
//		}
//		return json;
	}
	
//	//个人注册-2：填写详细信息
//	@RequestMapping("/regbyuserinfo.htm")
//	public ModelAndView regbyuserinfo(HttpServletRequest request){
//		return new ModelAndView("regbyuserinfo");
//	}
	
	//个人注册-3：注册成功
		@RequestMapping("/regbyuserok.htm")
		public ModelAndView regbyuserok(HttpServletRequest request){
			return new ModelAndView("regbyuserok");
		}
		
	
	//企业注册
	@RequestMapping("/regbyenterprise.htm")
	public ModelAndView RegisterByEnterprise(HttpServletRequest request){
		return new ModelAndView("regbyenterprise");
	}
	
	
	
	@RequestMapping("/login2.htm")
	@ResponseBody
	public JSONObject insertLed(HttpServletRequest request,PayBanksOffers model){
		JSONObject json = new JSONObject();
		
		try {
			String string=request.getParameter("companyName");
			json.put("Result", true);
			json.put("Msg", "操作成功");
		}
		catch(Exception e)
		{
			
		}
		return json;
	}
}
