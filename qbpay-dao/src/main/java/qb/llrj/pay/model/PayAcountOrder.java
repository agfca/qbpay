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

@Entity
@Table(name="pay_acount_order")
public class PayAcountOrder  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
 	private String bankid;//客户姓名 公司名称
	private String bankname;//社会统一代码 
	private Date createTime;
	private Date finishTime;
  	private String coopId;//公司id
 	private float momey; //批复金额
	private String ext1;
	private String ext2;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=50)
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	@Column(length=50)
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="createtime")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="finishtime")
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	@Column(length=50,name="coopid")
	public String getCoopId() {
		return coopId;
	}
	public void setCoopId(String coopId) {
		this.coopId = coopId;
	}
	@Column
	public float getMomey() {
		return momey;
	}
	public void setMomey(float momey) {
		this.momey = momey;
	}
	@Column(length=50)
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	@Column(length=50)
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	
}
