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
@Table(name="pay_banks_offers")
public class PayBanksOffers  implements Serializable{
	/**
	 * coop check really 
	 */
	private static final long serialVersionUID = 1L;
	private int 	id;								//主键ID
 	private String 	companyName;					//公司名称
	private String 	legalPerson;					//法定代表人
	private String 	legalPersonImage;				//法定代表人正面照
	private String 	legalPersonCode;				//法定代表身份证号
	private Date 	legalPersonBeginDate;			//法人身份证有效期开始日期
	private Date 	legalPersonEndDate;				//法人身份证有效期结束日期
	private int legalPersonDateIsAlways;			//法人身份证是否长期有效
	
  	private String 	businessLicenceCode;			//营业执照号
  	private String 	businessLicenceImage;			//营业执照号图片
  	private Date   	businessEndDate;				//营业执照号有效期
  	private String 	businessAddrress;				//营业执照地址
  	private Integer businessTypeKey;				//经营范围(键)
  	private String 	businessTypeValue;				//经营范围(值)
  	
  	private String 	businessPerson;					//业务负责人
  	private String 	businessPesronCode;				//业务负责人身份证号码
  	private Date 	businessPesronBeginDate;		//业务负责人身份证有效期开始日期
	private Date 	businessPesronEndDate;			//业务负责人身份证有效期结束日期
	private String 	businessPersonTel;				//业务负责人手机号码
	private String 	businessFaxCode;				//传真
	private Integer businessProvinceId;				//省份（ID）
	private String  businessProvinceTxt;			//省份（文本）
	private Integer businessCityId;					//城市、区	（ID）
	private String  businessCityTxt;				//城市、区（文本）
	private String  businessAddress;				//经营地址
	
	private Integer examineStateKey; 				//审核状态(键)
	private String  examineStateTxt; 				//审核状态(值)
	
	private Integer creatBy;						//创建人
	private Date 	creatOn;						//创建日期
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(length=50,name="companyname")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(length=50,name="legalperson")
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	@Column(length=50,name="legalpersonimage")
	public String getLegalPersonImage() {
		return legalPersonImage;
	}
	public void setLegalPersonImage(String legalPersonImage) {
		this.legalPersonImage = legalPersonImage;
	}
	@Column(length=50,name="legalpersoncode")
	public String getLegalPersonCode() {
		return legalPersonCode;
	}
	public void setLegalPersonCode(String legalPersonCode) {
		this.legalPersonCode = legalPersonCode;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="legalpersonbegindate")
	public Date getLegalPersonBeginDate() {
		return legalPersonBeginDate;
	}
	public void setLegalPersonBeginDate(Date legalPersonBeginDate) {
		this.legalPersonBeginDate = legalPersonBeginDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="legalpersonenddate")
	public Date getLegalPersonEndDate() {
		return legalPersonEndDate;
	}
	public void setLegalPersonEndDate(Date legalPersonEndDate) {
		this.legalPersonEndDate = legalPersonEndDate;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0",name="legalpersondateisalways") 
	public int getLegalPersonDateIsAlways() {
		return legalPersonDateIsAlways;
	}
	
	public void setLegalPersonDateIsAlways(int legalPersonDateIsAlways) {
		this.legalPersonDateIsAlways = legalPersonDateIsAlways;
	}
	@Column(length=50,name="businesslicencecode")
	public String getBusinessLicenceCode() {
		return businessLicenceCode;
	}
	public void setBusinessLicenceCode(String businessLicenceCode) {
		this.businessLicenceCode = businessLicenceCode;
	}
	@Column(length=150,name="businesslicenceimage")
	public String getBusinessLicenceImage() {
		return businessLicenceImage;
	}
	public void setBusinessLicenceImage(String businessLicenceImage) {
		this.businessLicenceImage = businessLicenceImage;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="businessenddate")
	public Date getBusinessEndDate() {
		return businessEndDate;
	}
	public void setBusinessEndDate(Date businessEndDate) {
		this.businessEndDate = businessEndDate;
	}
	@Column(length=150,name="businessaddrress")
	public String getBusinessAddrress() {
		return businessAddrress;
	}
	public void setBusinessAddrress(String businessAddrress) {
		this.businessAddrress = businessAddrress;
	}
	@Column(length=50,name="businesstypekey")
	public Integer getBusinessTypeKey() {
		return businessTypeKey;
	}
	public void setBusinessTypeKey(Integer businessTypeKey) {
		this.businessTypeKey = businessTypeKey;
	}
	@Column(length=50,name="businesstypevalue")
	public String getBusinessTypeValue() {
		return businessTypeValue;
	}
	public void setBusinessTypeValue(String businessTypeValue) {
		this.businessTypeValue = businessTypeValue;
	}
	@Column(length=50,name="businessperson")
	public String getBusinessPerson() {
		return businessPerson;
	}
	public void setBusinessPerson(String businessPerson) {
		this.businessPerson = businessPerson;
	}
	@Column(length=50,name="businesspesroncode")
	public String getBusinessPesronCode() {
		return businessPesronCode;
	}
	public void setBusinessPesronCode(String businessPesronCode) {
		this.businessPesronCode = businessPesronCode;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="businesspesronbegindate")
	public Date getBusinessPesronBeginDate() {
		return businessPesronBeginDate;
	}
	public void setBusinessPesronBeginDate(Date businessPesronBeginDate) {
		this.businessPesronBeginDate = businessPesronBeginDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="businesspesronenddate")
	public Date getBusinessPesronEndDate() {
		return businessPesronEndDate;
	}
	public void setBusinessPesronEndDate(Date businessPesronEndDate) {
		this.businessPesronEndDate = businessPesronEndDate;
	}
	@Column(length=50,name="businesspersontel")
	public String getBusinessPersonTel() {
		return businessPersonTel;
	}
	public void setBusinessPersonTel(String businessPersonTel) {
		this.businessPersonTel = businessPersonTel;
	}
	@Column(length=50,name="businessfaxcode")
	public String getBusinessFaxCode() {
		return businessFaxCode;
	}
	public void setBusinessFaxCode(String businessFaxCode) {
		this.businessFaxCode = businessFaxCode;
	}
	@Column(name="businessprovinceid")
	public Integer getBusinessProvinceId() {
		return businessProvinceId;
	}
	public void setBusinessProvinceId(Integer businessProvinceId) {
		this.businessProvinceId = businessProvinceId;
	}
	@Column(length=150,name="businessprovincetxt")
	public String getBusinessProvinceTxt() {
		return businessProvinceTxt;
	}
	public void setBusinessProvinceTxt(String businessProvinceTxt) {
		this.businessProvinceTxt = businessProvinceTxt;
	}
	@Column(name="businesscityid")
	public Integer getBusinessCityId() {
		return businessCityId;
	}
	public void setBusinessCityId(Integer businessCityId) {
		this.businessCityId = businessCityId;
	}
	@Column(length=150,name="businesscitytxt")
	public String getBusinessCityTxt() {
		return businessCityTxt;
	}
	public void setBusinessCityTxt(String businessCityTxt) {
		this.businessCityTxt = businessCityTxt;
	}
	@Column(length=150,name="businessaddress")
	public String getBusinessAddress() {
		return businessAddress;
	}
	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
	@Column(name="examinestatekey")
	public Integer getExamineStateKey() {
		return examineStateKey;
	}
	public void setExamineStateKey(Integer examineStateKey) {
		this.examineStateKey = examineStateKey;
	}
	@Column(length=150,name="examinestatetxt")
	public String getExamineStateTxt() {
		return examineStateTxt;
	}
	public void setExamineStateTxt(String examineStateTxt) {
		this.examineStateTxt = examineStateTxt;
	}
	@Column(name="creatby")
	public Integer getCreatBy() {
		return creatBy;
	}
	public void setCreatBy(Integer creatBy) {
		this.creatBy = creatBy;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 10,name="creaton")
	public Date getCreatOn() {
		return creatOn;
	}
	public void setCreatOn(Date creatOn) {
		this.creatOn = creatOn;
	}
}
