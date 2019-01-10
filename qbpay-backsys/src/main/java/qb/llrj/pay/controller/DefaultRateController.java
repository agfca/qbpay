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

import qb.llrj.pay.model.DefaultRate;
import qb.llrj.pay.service.DefaultRateService;

/**
 * @ClassName:			DefaultRateController
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月8日  下午3:13:01
 */
@Controller
@RequestMapping("/defaultRate")
public class DefaultRateController {
	
	@Autowired
	private DefaultRateService service;
	
	@RequestMapping("/indexDefaultRate.htm")
	public String indexDefaultRate(){
		return "defaultRateControl";
	}
	
	@RequestMapping("/loadDefaultRate.htm")
	@ResponseBody
	public List<DefaultRate> loadDefaultRate(Integer tTypeId,Integer productId){
		List<DefaultRate> rates = new ArrayList<DefaultRate>();
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("tTypeId", tTypeId == null ? 0 : tTypeId);
			param.put("productId", productId == null ? 0 : productId);
			
			rates = service.findByParam(param);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rates;
	}
	
	@RequestMapping("/addOrEditDefaultRate.htm")
	@ResponseBody
	public JSONObject addOrEditDefaultRate(DefaultRate defaultRate){
		JSONObject obj = new JSONObject();
		try {
			if(defaultRate.getId() != 0){
				service.updateByPrimaryKey(defaultRate);
			}else{
				service.insert(defaultRate);
			}
			obj.put("statu", true);
			obj.put("msg", "操作成功");
		} catch (Exception e) {
			obj.put("statu", false);
			obj.put("msg", "系统错误");
			e.printStackTrace();
		}
		return obj;
	}
	
	@RequestMapping("/delDefaultRate.htm")
	@ResponseBody
	public JSONObject delDefaultRate(int id){
		JSONObject obj = new JSONObject();
		try {
			service.deleteByPrimaryKey(id);
			obj.put("statu", true);
			obj.put("msg", "操作成功");
		} catch (Exception e) {
			obj.put("statu", false);
			obj.put("msg", "系统错误");
			e.printStackTrace();
		}
		return obj;
	}
}


