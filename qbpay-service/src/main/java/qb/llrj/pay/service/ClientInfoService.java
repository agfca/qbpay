package qb.llrj.pay.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import qb.llrj.pay.model.Client;

  

/** 
 * @Title: T_PersonInfoService.java 
 * @Package com.llrj.service 
 * @Description: 
 * @author 作者 OuYao: 
 * @version 创建时间：2017-10-13 下午5:09:52 
 *
 */
@Service
public interface ClientInfoService {
	
	/**
	 * 插入数据
	 * */
	public abstract Boolean insertModel(Client model);
	
	//根据电话号码查询，返回实体对象
	public abstract  Client selectByPhone(Map<String, Object> map);
	
	//根据编号查询，返回实体对象
	public abstract  Client selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(Client record);
	
	//删除数据
	int deleteByPrimaryKey(Integer id);
	
	//删除数据(可能是多条件)
	int deleteByMap(Map<String, Object> map);
	
	//获取当前账户下的子账户(含本账户)
	List< Map<String, Object>> findListByCurrentId(Map<String, Object> map);
	 
	//获取单个实体：根据socialUnifiedCode 社会统一代码 或身份证号码 （个人）
	 Client selectByUnifiedCode(Map<String, Object> map);
	 
	 /**
     * 根据条件分页查询
     * @param map
     * @return
     */
    List<Client> findClientByParam(Map<String, Object> map);
    
    /**
     * 条件查询总条数
     * @param map
     * @return
     */
    int findClientCountByParam(Map<String, Object> map);
}
