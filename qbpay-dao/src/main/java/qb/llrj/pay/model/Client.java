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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="client")
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
 	private String  clientName;				//客户姓名或 公司名称
 	private String 	clientPhone;			//客户电话
	private String  socialUnifiedCode;		//社会统一代码 或身份证号码 （个人）
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  clientCodeStartDate;	//证件有效开始日期
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  clientCodeEndDate;		//证件有效结束日期
	
	private Integer clientProvinceId;		//省份（ID）
 	private String  clientProvinceTxt;		//省份（文本）
	private Integer clientCityId;			//城市、区	（ID）
	private String  clientCityTxt;			//城市、区（文本）
	private String  clientAddress;			//地址
	private int 	clientType;				//用户类型：-1后台用户 1：用户注册  2：企业注册
	private String 	clientNumber;			//商户号 app_id

	private Date createTime;					//创建日期
	private String password;					//登录密码
	private String payPassword;				//支付密码 
	private String coopName;				//公司名字 
  	
	private String siteName;				//负责人姓名
	private String siteURL;					//公司网址
	private String userEmail;				//注册邮件
	private String userKey;					//用户key
	private String userQQ;					//用户QQ
	private Integer userStatus;					//用户状态，是否实名认证 0未认证  1已认证
	private String fBankId;					//银行卡
	private String fBankName;				//银行名称
 	private String fBankSeat;				//银行地址
	private String userTel;					//业务负责人手机号码
	private String overTime; 				//结算时间 1-7天
    private Integer parentid;		//主账号
    private Integer  clientCodeDateState;//身份证是否长期有效 1长期有效 0 默认不长期有效
    private Integer roleId;//角色
 	private String ext1;
	private String ext2;
	private String ext3;
	private String ext4;
	private String ext5;
	private String clientAreaTxt;
	private Integer clientAreaId;
	
	private Integer clientStatus;					//客户状态，1：正常 0：禁用 
	
	@Column(name = "clientareaid")
	public Integer getClientAreaId() {
		return clientAreaId;
	}
	public void setClientAreaId(Integer clientAreaId) {
		this.clientAreaId = clientAreaId;
	}
	@Column(length = 50,name = "clientareatxt")
	public String getClientAreaTxt() {
		return clientAreaTxt;
	}
	public void setClientAreaTxt(String clientAreaTxt) {
		this.clientAreaTxt = clientAreaTxt;
	}
	@Column 
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	@Column(name = "clientcodedatestate",columnDefinition="Integer default 0") 
	public Integer getClientCodeDateState() {
		return clientCodeDateState;
	}
	public void setClientCodeDateState(Integer clientCodeDateState) {
		this.clientCodeDateState = clientCodeDateState;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name = "clientcodestartdate")
	public Date getClientCodeStartDate() {
		return this.clientCodeStartDate;
	}
	public void setClientCodeStartDate(Date clientCodeStartDate) {
		this.clientCodeStartDate = clientCodeStartDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="clientcodeenddate")
	public Date getClientCodeEndDate() {
		return this.clientCodeEndDate;
	}
	
	public void setClientCodeEndDate(Date clientCodeEndDate) {
		this.clientCodeEndDate = clientCodeEndDate;
	}
	
	@Column(name = "clientprovinceid")
	public Integer getClientProvinceId() {
		return this.clientProvinceId;
	}
	
	public void setClientProvinceId(Integer clientProvinceId) {
		this.clientProvinceId = clientProvinceId;
	}
	@Column(length = 50,name = "clientprovincetxt")
	public String getClientProvinceTxt() {
		return this.clientProvinceTxt;
	}
	public void setClientProvinceTxt(String clientProvinceTxt) {
		this.clientProvinceTxt = clientProvinceTxt;
	}
	
	@Column(name = "clientcityid")
	public Integer getClientCityId() {
		return this.clientCityId;
	}
	public void setClientCityId(Integer clientCityId) {
		this.clientCityId = clientCityId;
	}
	@Column(length = 50,name = "clientcitytxt")
	public String getClientCityTxt() {
		return this.clientCityTxt;
	}
	public void setClientCityTxt(String clientCityTxt) {
		this.clientCityTxt = clientCityTxt;
	}
	@Column(length = 100,name = "clientaddress")
	public String getClientAddress() {
		return this.clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	@Column(name = "clienttype")
	public Integer getClientType() {
		return this.clientType;
	}
	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}
	
	@Column(length = 50,name = "clientnumber")
	public String getClientNumber() {
		return this.clientNumber;
	}
	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}
	
 	 
	@Column(length=100,name = "coopname")
	public String getCoopName() {
		return coopName;
	}
	public void setCoopName(String coopName) {
		this.coopName = coopName;
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
	public String getExt5() {
		return ext5;
	}
	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@Column(length=50,name = "fbankid")
	public String getfBankId() {
		return fBankId;
	}
	public void setfBankId(String fBankId) {
		this.fBankId = fBankId;
	}
	@Column(length=100,name = "fbankname")
	public String getfBankName() {
		return fBankName;
	}
	public void setfBankName(String fBankName) {
		this.fBankName = fBankName;
	}
	@Column(length=100,name = "fbankseat")
	public String getfBankSeat() {
		return fBankSeat;
	}
	public void setfBankSeat(String fBankSeat) {
		this.fBankSeat = fBankSeat;
	}
	
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	
	@Column(length=50,name = "socialunifiedcode")
	public String getSocialUnifiedCode() {
		return socialUnifiedCode;
	}
	public void setSocialUnifiedCode(String socialUnifiedCode) {
		this.socialUnifiedCode = socialUnifiedCode;
	}
	@Column(length=20,name = "paypassword")
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name = "overtime")
	public String getOverTime() {
		return overTime;
	}
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name = "createtime")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=50,name="sitename")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	@Column(length=150,name="siteurl")
	public String getSiteURL() {
		return siteURL;
	}
	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}
	@Column(length=50,name="userEmail")
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Column(length=64,name="userkey")
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	@Column(length=15,name="userqq")
	public String getUserQQ() {
		return userQQ;
	}
	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0",name="userstatus") 
	public Integer getUserStatus() {
		return userStatus;
	}
	
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	@Column(length=20,name="usertel")
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	@Column(length=20,name="clientphone")
	public String getClientPhone() {
		return clientPhone;
	}
	
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	@Column(nullable=false,columnDefinition="INT default 1",name="clientstatus") 
	public Integer getClientStatus() {
		return clientStatus;
	}
	public void setClientStatus(Integer clientStatus) {
		this.clientStatus = clientStatus;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Column(length=50,name = "clientname")
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
  
}