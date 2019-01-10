package qb.llrj.pay.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;

import qb.llrj.pay.model.Client;
import qb.llrj.pay.model.Order;

/**
* @author  ：
* @date ：2019年1月8日 上午10:30:01
* @ClassName ：OrderService
*/
public interface OrderService {
	
	//前台订单查询
	public abstract JSONArray queryorder(Map<String, Object> param);
	//根据客户id查询总订单数 ，前台
	public abstract int getcount(Map<String, Object> param);
	
	//后台订单查询
	public abstract JSONArray backorder(Map<String, Object> param);
	//后台订单总数
	public abstract int backordercount(Map<String, Object> param);
}
