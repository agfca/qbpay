package qb.llrj.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qb.llrj.pay.model.Client;
import qb.llrj.pay.model.PayBanksOffers;
import qb.llrj.pay.service.ClientInfoService;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;


/**
 * client 注册
 */
@Controller
@RequestMapping("/register")
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientInfoService clientInfoService;


	/**判断用户是否存在 TODO */
	private boolean exist(String username){
		//Client client = clientInfoService.findByName(username);
		Client client = new Client();
		return (client !=null);
	}

	/**加密密码  TODO */
	private String encryptPassword(String pwd){
		//pwd = new BCryptPasswordEncoder().encode(pwd);
		return pwd;
	}

	@RequestMapping("/regbyuser.htm")
	public String index(HttpServletRequest request){
		String phonestate = (String)request.getAttribute("phonestate");
		if(phonestate!=null){
			return "regbyuserinfo";
		}else{
			return "regbyuser";
		}
	}

	//个人注册1:手机号码验证（接口）
	@RequestMapping("/regbyusercheck.htm")
	public String regbyusercheck(HttpServletRequest request){
		//业务逻辑处理
		request.setAttribute("phonestate", "17774977753");
		return "forward:regbyuser.htm";
	}


	//个人注册2:提交册详细信息（接口）
	@RequestMapping("/regbyusersub.htm")
	public String regbyusersub(HttpServletRequest request){
		//个人注册成功
		request.setAttribute("substate","1");
		String reString = "forward:regbyuser.htm";
		return reString;
	}

	//注册信息 提交
	@RequestMapping("/register.htm")
	public String registerClient(
			HttpServletRequest request
			,@RequestParam String username
			,@RequestParam String password
			,@RequestParam String userTel
	){

		//TODO  此处省略校验逻辑
		//"用户是否存在："
		if(exist(username)){
			request.setAttribute("status","exist");
			return "forward:client.htm";//用户存在
		}
		//密码加密  保存
		//Client client = clientInfoService.register(username,encryptPassword(password),userTel);
		Client client = new Client();

		int aa = client.getId();
		if(client.getId()>0){
			request.setAttribute("status","true");
			return "forward:client.htm";
			//注册成功
		}else{
			request.setAttribute("status","false");
			return "forward:client.htm";
		}
	}

}
