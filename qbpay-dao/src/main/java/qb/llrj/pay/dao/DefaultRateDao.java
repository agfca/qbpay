package qb.llrj.pay.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import qb.llrj.pay.model.DefaultRate;

/**
 * @ClassName:			DefaultRateDao
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月8日  下午3:01:15
 */
@Repository
public interface DefaultRateDao {
	
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


