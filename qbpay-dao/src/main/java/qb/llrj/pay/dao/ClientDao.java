package qb.llrj.pay.dao;

import java.util.List;
import java.util.Map;

import qb.llrj.pay.model.Client;

   
/** 
  * @Description: 
  * @version 创建时间：2019-1-2  
 *
 */
  public interface ClientDao {
	
	   int deleteByMap(Map<String, Object> map);
	   
	   int deleteByPrimaryKey(Integer id);

	    int insert(Client model);

	    Client selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Client record);

	    int updateByPrimaryKey(Client record);
	    
	    Client selectByPhone(Map<String, Object> map);
	    
	    /**
	     * 查询实体
	     *@parem socialUnifiedCode :社会统一代码 或身份证号码 （个人）
	    */
	    Client selectByUnifiedCode(Map<String, Object> map);
	    
	    /**
	     * 查询当前登录账号的子账号
	     * @param map
	     * @return
	     */
	    List< Map<String, Object>> findListByCurrentId(Map<String, Object> map);
	    
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
