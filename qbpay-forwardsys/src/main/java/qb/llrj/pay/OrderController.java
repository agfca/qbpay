package qb.llrj.pay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Array;

import qb.llrj.pay.model.Client;
import qb.llrj.pay.model.Order;
import qb.llrj.pay.service.OrderService;

/**
* @author  ：
* @date ：2019年1月8日 上午10:16:09
* @ClassName ：OrderController
*/

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	//前台订单查询业务逻辑处理
	@RequestMapping("/queryorderall.htm")
	@ResponseBody
	public JSONObject queryorderall(HttpSession session,Integer limit,Integer offset,Integer statu){
		JSONObject object = new JSONObject();
		JSONArray json = null;
		Client client = new Client();
		try { 
			client = (Client) session.getAttribute("user");
			if(client == null){
				object.put("statu", false);
				object.put("msg", "尚未登录");
				return object;
			}
			Map<String, Object> param = new HashMap<>();
			param.put("id", client.getId());
			param.put("rows", limit);
			param.put("page", offset);
			param.put("status", statu);
			json = orderservice.queryorder(param);
			int total = orderservice.getcount(param);
			object.put("res", json);
			object.put("total", total);
			object.put("statu", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
}
