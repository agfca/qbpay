package qb.llrj.pay.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import qb.llrj.pay.dao.OrderDao;
import qb.llrj.pay.model.Client;
import qb.llrj.pay.model.Order;
import qb.llrj.pay.service.OrderService;

/**
* @author  ：
* @date ：2019年1月8日 上午10:32:20
* @ClassName ：OrderServiceImpl
*/
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao dao;
	
	//前台订单查询
	@Override
	public JSONArray queryorder(Map<String, Object> param) {
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(dao.queryorder(param)));
		return json;
	}
	
	//根据客户id查询总订单数
	@Override
	public int getcount(Map<String, Object> param) {
		int count = dao.getcount(param);
		return count;
	}
	//
	@Override
	public JSONArray backorder(Map<String, Object> param) {
		JSONArray json = JSONArray.parseArray(JSON.toJSONString(dao.backorder(param)));
		return json;
	}
	//
	@Override
	public int backordercount(Map<String, Object> param) {
		int count = dao.backordercount(param);
		return count;
	}


}
