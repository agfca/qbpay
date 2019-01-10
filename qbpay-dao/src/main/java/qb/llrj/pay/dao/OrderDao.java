package qb.llrj.pay.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import qb.llrj.pay.model.Client;
import qb.llrj.pay.model.Order;

/**
* @author  ：
* @date ：2019年1月8日 上午10:03:08
* @ClassName ：OederDao
*/

public interface OrderDao {
	//前台订单查询
	List<Order> queryorder(Map<String, Object> param);
	//前台订单总条数
	int getcount(Map<String,Object> param);
	
	//后台订单查询
	List<Order> backorder(Map<String, Object> param);
	//后台订单总数
	int backordercount(Map<String,Object> param);
}
