package qb.llrj.pay.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qb.llrj.pay.dao.DefaultRateDao;
import qb.llrj.pay.model.DefaultRate;
import qb.llrj.pay.service.DefaultRateService;

/**
 * @ClassName:			DefaultRateServiceImpl
 * @Description:		
 * @author:          	OuYao
 * @date:    			2019年1月8日  下午3:11:30
 */
@Service
@Transactional
public class DefaultRateServiceImpl implements DefaultRateService {
	
	@Autowired
	private DefaultRateDao dao;
	
	@Override
	public int insert(DefaultRate record) {
		return dao.insert(record);
	}

	@Override
	public int updateByPrimaryKey(DefaultRate record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public DefaultRate selectByPrimaryKey(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public List<DefaultRate> findAll() {
		return dao.findAll();
	}

	@Override
	public List<DefaultRate> findByParam(Map<String, Object> param) {
		return dao.findByParam(param);
	}

}


