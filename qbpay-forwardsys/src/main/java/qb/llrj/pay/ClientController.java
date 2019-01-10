package qb.llrj.pay;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import qb.llrj.pay.service.ClientInfoService;

 
/**
 * @ClassName: ExtendController
  */
@Controller
@RequestMapping("/user")
public class ClientController implements Serializable {

	private static final long serialVersionUID = 3803195153411347397L;
	
	@Autowired
	private ClientInfoService clientService;
	

	@RequestMapping("/login.htm")
	public String login(HttpServletRequest request){
		return "login";
	}
	 
}
