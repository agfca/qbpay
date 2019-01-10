package qb.llrj.pay.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the CardRate database table.
 * 产品默认费率
 */
@Entity
@Table(name="default_rate")
 public class DefaultRate implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String ext;
	private String ext1;
	private String productId;//产品编码 11，当面付扫码  12.条形扫码，13.商店直接扫码  //  21，微信扫码，22，条形扫码
 	private String productName;//产品名称   当面付  条形扫码  APP支付包 
	private double proportion;//默认费率
 	private int status;//0,关闭状态 1 开启  默认开启
  	private int tTypeId;//大类id 1微信，2支付宝，3银联
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
	
	@Column 
	public double getProportion() {
		return proportion;
	}
	
	public void setProportion(double proportion) {
		this.proportion = proportion;
	}
	
	 
	@Column(length=2,name="ttypeid")
	public int gettTypeId() {
		return tTypeId;
	}

	public void settTypeId(int tTypeId) {
		this.tTypeId = tTypeId;
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

	@Column(nullable=false,columnDefinition="INT default 1") 
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	 
	 
}