package qb.llrj.pay.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import qb.llrj.pay.model.Client;
import qb.llrj.pay.model.DayTotal;

@Service
public interface DayTotalService {
	
	//获取当前账户下结算信息
	List<DayTotal> findListByMap(Map<String, Object> map);
}
