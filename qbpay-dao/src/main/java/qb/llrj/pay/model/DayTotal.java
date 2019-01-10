package qb.llrj.pay.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//每天统计当天各个支付类型的金额
@Entity
@Table(name="day_total")
public class DayTotal  implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
 
    /** 商户注册名称 */
    private String clientName;
    
    private String clientId;
   
 	/** 商户卡类型面额 */
    private float factMoney;//实际支付金额

    private float referMoney;//提交金额

    private float realityMoney;//可体现金额

    private Date createTime;
    
    private int tTypeId;//大类 支付宝，微信，银联
 
	/**结算状态(0为未结算，1为以结算)*/
    private int memo;
    
    @Column(length=2,name="ttypeid")
	public int gettTypeId() {
		return tTypeId;
	}

	public void settTypeId(int tTypeId) {
		this.tTypeId = tTypeId;
	}

	@Column(length=50,name="clientid")
	public String getClientId() {
  		return clientId;
  	}

  	public void setClientId(String clientId) {
  		this.clientId = clientId;
  	}
  	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(length=50,name="clientname")
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	@Column(name="factmoney") 
	public float getFactMoney() {
		return factMoney;
	}

	public void setFactMoney(float factMoney) {
		this.factMoney = factMoney;
	}
	@Column(name="refermoney") 
	public float getReferMoney() {
		return referMoney;
	}

	public void setReferMoney(float referMoney) {
		this.referMoney = referMoney;
	}
	
	@Column(name="realitymoney") 
	public float getRealityMoney() {
		return realityMoney;
	}

	public void setRealityMoney(float realityMoney) {
		this.realityMoney = realityMoney;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="createtime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0") 
	public int getMemo() {
		return memo;
	}

	public void setMemo(int memo) {
		this.memo = memo;
	}
 
}
