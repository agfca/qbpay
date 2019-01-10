package qb.llrj.pay.service.impl;

import org.apache.ibatis.scripting.xmltags.VarDeclSqlNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import qb.llrj.pay.dao.ClientDao;
import qb.llrj.pay.dao.DayTotalDao;
import qb.llrj.pay.model.Client;
import qb.llrj.pay.model.DayTotal;
import qb.llrj.pay.service.ClientInfoService;
import qb.llrj.pay.service.DayTotalService;
import qb.llrj.pay.util.Md5Util;

import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DayTotalServiceImpl implements DayTotalService {

	@Autowired
	private DayTotalDao dayTotalDao;

	@Override
	public List<DayTotal> findListByMap(Map<String, Object> map){
		List<DayTotal> list = null;
		if(map==null){
			return list;
		}
		try{
			list=dayTotalDao.findListByMap(map);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
