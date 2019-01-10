package qb.llrj.pay.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the CardProduct database table.
 * 公司产品表
 */
@Entity
@Table(name="product_coop")
 public class ProductCoop implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private int id;
	private String ext;
	private String ext1;
	private String ext2;
	private String clientName;//客户名称
	private String clientNo;//客户ID
 	private String proportion;//产品费率
	private int status;//状态 0,关闭，1开启 默认关闭
	private String productId;//类型id
 	private String productName;//类型名称
 	private String coopId;//公司id
 	private int tTypeId;//大类id 
  	private String notifyUrl;//异步反馈地址
  	private String returnUrl;//同步反馈地址
 	private String submitUrl;//提交反馈地址
 	
 	@Column(length=150,name="notifyurl")
	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	@Column(length=150,name="returnurl")
	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	@Column(length=150,name="submiturl")
	public String getSubmitUrl() {
		return submitUrl;
	}

	public void setSubmitUrl(String submitUrl) {
		this.submitUrl = submitUrl;
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
	private String remark;//产品说明 
 	
	@Column(length=50)
 	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(length=50,name="clientno")
	public String getClientNo() {
		return clientNo;
	}
	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
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
	@Column(length=50,name="clientname")
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	@Column(length=10)
	public String getProportion() {
		return proportion;
	}
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	@Column(length=50)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(length=50,name="coopid")
	public String getCoopId() {
		return coopId;
	}
	public void setCoopId(String coopId) {
		this.coopId = coopId;
	}
	
	@Column(name="ttypeId") 
	public int gettTypeId() {
		return tTypeId;
	}
	public void settTypeId(int tTypeId) {
		this.tTypeId = tTypeId;
	}
	 
	 
 
   

}