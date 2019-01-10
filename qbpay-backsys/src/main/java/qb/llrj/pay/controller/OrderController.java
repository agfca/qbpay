package qb.llrj.pay.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jodd.util.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import qb.llrj.pay.model.Client;
import qb.llrj.pay.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/backorder.htm")
	@ResponseBody
	public JSONObject backorder(HttpServletRequest request,Integer limit,Integer offset,Integer statu,String clientName){
		JSONObject object = new JSONObject();
		JSONArray json = null;
		try { 
			Map<String, Object> param = new HashMap<>();
			param.put("rows", limit);
			param.put("page", offset);
			param.put("status", statu);
			clientName = new String(clientName.getBytes("ISO-8859-1"), "UTF-8");
			param.put("clientName",clientName);
			json = orderService.backorder(param);
			int total = orderService.backordercount(param);
			object.put("res", json);
			object.put("total", total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}
}
