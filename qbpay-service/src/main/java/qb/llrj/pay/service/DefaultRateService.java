package qb.llrj.pay.service;

import java.util.List;
import java.util.Map;

import qb.llrj.pay.model.DefaultRate;

/**
 * @ClassName:			DefaultRateService
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月8日  下午3:11:04
 */
public interface DefaultRateService {
	
	int insert(DefaultRate record);
	
	int updateByPrimaryKey(DefaultRate record);
	
	int deleteByPrimaryKey(Integer id);
	
	DefaultRate selectByPrimaryKey(Integer id);
	
	List<DefaultRate> findAll();
	
	/**
	 * 条件查询
	 * @param param
	 * @return
	 */
	List<DefaultRate> findByParam(Map<String, Object> param);
}


