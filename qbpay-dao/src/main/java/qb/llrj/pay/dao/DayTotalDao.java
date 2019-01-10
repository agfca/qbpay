package qb.llrj.pay.dao;

import java.util.List;
import java.util.Map;

import qb.llrj.pay.model.DayTotal;
import qb.llrj.pay.model.Order;

/**
* @author  ：
* @date ：2019年1月8日 上午10:03:08
* @ClassName ：OederDao
*/

public interface DayTotalDao {
	
	List<DayTotal> findListByMap(Map<String, Object> map);
}
