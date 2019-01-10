package qb.llrj.pay.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import qb.llrj.pay.model.Client;
import qb.llrj.pay.service.ClientInfoService;

/**
 * @ClassName:			ClientControl
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月9日  上午11:25:05
 */
@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientInfoService clientService;
	
	@RequestMapping("/index.htm")
	private String index(){
		return "clientControl";
	}
	
	@RequestMapping("/loadClient.htm")
	@ResponseBody
	public JSONObject loadClient(Integer limit,Integer offset,Integer clientType,String userStatus,String clientName){
		JSONObject obj = new JSONObject();
		try {
			
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("limit", limit == null ? 10 : limit);
			param.put("offset", offset == null ? 0 : offset);
			
			param.put("clientType", clientType == null ? 0 : clientType);
			param.put("clientName", clientName == null ? "" : clientName);
			param.put("userStatus", userStatus == null ? -1 : userStatus);
			
			obj.put("res", clientService.findClientByParam(param));
			obj.put("total", clientService.findClientCountByParam(param));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@RequestMapping("/editClientOverTime.htm")
	@ResponseBody
	public JSONObject editClientOverTime(Integer id,String overTime){
		JSONObject obj = new JSONObject();
		try {
			Client client = clientService.selectByPrimaryKey(id);
			if(client != null){
				client.setOverTime(overTime);
				if(clientService.updateByPrimaryKey(client) > 0){
					obj.put("statu", true);
					obj.put("msg", "保存成功");
				}
			}
		} catch (Exception e) {
			obj.put("statu", false);
			obj.put("msg", "保存失败，系统错误");
			e.printStackTrace();
		}
		return obj;
	}
}


