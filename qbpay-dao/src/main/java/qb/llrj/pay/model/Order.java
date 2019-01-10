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


/**
 * The persistent class for the CardOrder database table.
 * 订单
 */
@Entity
@Table(name="pay_order")
 public class Order implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private int id;
	private int tTypeid;//大分类（支付宝，微信，银联）
 	private String checkStatus;//订单发送成功 0,1
	private String clientName;//客户名称
	private String clientNo;//客户 id
	private String clientOrderId;//客户的订单号 
	private String clientReturnURL;//反馈 url
	private Date createTime;//创建订单时间
	private float factMoney;//提交真实金额 
	private Date fillTime;	//完成订单时间
	private String proportion;//费率 
	private float realityMoney;//费率后的真实金额
	private float referMoney;//余额
	private String remark;//备注
	private int status;//订单状态 0，创建订单，1，提交上级通道成功，处理中，2处理成功，3处理失败
	private String sysId;//系统 订单好
	private String productId;//支付类型 1 
 	private String productName;//类型名称
    private int work = 0;
    private int interferType;
    private String storeId;//分店id
    private String operatorId;//操作员id
   
	private String ext5;
	private String ext3;
	private String ext4;
	private String ext;
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
	@Column(name="ttypeid")  
	public int gettTypeid() {
		return tTypeid;
	}
	public void settTypeid(int tTypeid) {
		this.tTypeid = tTypeid;
	}
	@Column(length=30,name="checkstatus")
	public String getCheckStatus() {
		return checkStatus;
	}
	 @Column(length=30,name="operatorid")
		public String getOperatorId() {
			return operatorId;
		}
		public void setOperatorId(String operatorId) {
			this.operatorId = operatorId;
		}
    @Column(length=50,name="storeid")
    public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	@Column(length=50,name="clientname")
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@Column(length=50,name="clientno")
	public String getClientNo() {
		return clientNo;
	}
	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}
	@Column(length=50,name="clientorderid")
	public String getClientOrderId() {
		return clientOrderId;
	}
	public void setClientOrderId(String clientOrderId) {
		this.clientOrderId = clientOrderId;
	}
	@Column(length=250,name="clientreturnurl")
	public String getClientReturnURL() {
		return clientReturnURL;
	}
	public void setClientReturnURL(String clientReturnURL) {
		this.clientReturnURL = clientReturnURL;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="createtime")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="factmoney")
	public float getFactMoney() {
		return factMoney;
	}
	
	public void setFactMoney(float factMoney) {
		this.factMoney = factMoney;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="filltime")
	public Date getFillTime() {
		return fillTime;
	}
	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}
	@Column(length=10)
	public String getProportion() {
		return proportion;
	}
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	@Column(name="realitymoney") 
	public float getRealityMoney() {
		return realityMoney;
	}
	public void setRealityMoney(float realityMoney) {
		this.realityMoney = realityMoney;
	}
	@Column(name="refermoney") 
	public float getReferMoney() {
		return referMoney;
	}
	public void setReferMoney(float referMoney) {
		this.referMoney = referMoney;
	}
	@Column(length=50)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0") 
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(length=50,name="sysid")
	public String getSysId() {
		return sysId;
	}
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	@Column(length=50,name="productid")
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	@Column(length=50,name="productname")
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Column 
	public int getWork() {
		return work;
	}
	public void setWork(int work) {
		this.work = work;
	}
	@Column(name="interfertype")
	public int getInterferType() {
		return interferType;
	}
	public void setInterferType(int interferType) {
		this.interferType = interferType;
	}
	@Column(length=50)
	public String getExt5() {
		return ext5;
	}
	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}
	@Column(length=50)
	public String getExt3() {
		return ext3;
	}
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	@Column(length=50)
	public String getExt4() {
		return ext4;
	}
	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}
	@Column(length=50)
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
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