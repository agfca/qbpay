package qb.llrj.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import qb.llrj.pay.dao.ClientDao;
import qb.llrj.pay.model.Client;
import qb.llrj.pay.service.ClientInfoService;
import qb.llrj.pay.util.Md5Util;

import java.util.List;
import java.util.Map;

import java.util.Date;

@Service
@Transactional
public class ClientInfoServiceImpl implements ClientInfoService {

	@Autowired
	private ClientDao clientDao;

	public Client login(String persion_code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Client selectByPrimaryKey(Integer id) {
		return clientDao.selectByPrimaryKey(id);
	}
	
	@Override
	public Boolean insertModel(Client model) {

		Boolean result = false;
		try {
			clientDao.insert(model);
			if (model.getId() > 0) {
				result = true;
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public Client selectByPhone(Map<String, Object> map) {
		return clientDao.selectByPhone(map);
	}
	@Override
	public List< Map<String, Object>>findListByCurrentId(Map<String, Object> map) {
		List< Map<String, Object>> list = null;
		try {
			if (map == null) {
				return list;
			}
			list = clientDao.findListByCurrentId(map);
		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public List<Client> findClientByParam(Map<String, Object> map) {
		return clientDao.findClientByParam(map);
	}

	@Override
	public int findClientCountByParam(Map<String, Object> map) {
		return clientDao.findClientCountByParam(map);
	}

	@Override
	public int updateByPrimaryKey(Client record) {
		return clientDao.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return clientDao.deleteByPrimaryKey(id);
	}
	@Override
	public int deleteByMap(Map<String, Object> map) {
		return clientDao.deleteByMap(map);
	}
	
	
	@Override
	public Client selectByUnifiedCode(Map<String, Object> map) {
		return clientDao.selectByUnifiedCode(map);
	}



	@Override
	public Client register(String username, String password,String userTel) {
		Client client = new Client();
		//client.setUsername(username);
		client.setPassword(password);
		client.setUserTel(userTel);
		client.setCreateTime(new Date());
		//dao.insert();
		return null;
	}

	@Override
	public Client findByName(String username) {
		//return dao.findByName(username);
		return null;
	}

}
