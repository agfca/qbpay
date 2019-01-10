package qb.llrj.pay.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName:			Role
 * @Description:		角色信息类
 * @author:          	OuYao
 * @date:    			2019年1月4日  上午10:41:17
 */
@Entity
@Table(name="role")
public class Role implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3878542943063594723L;
	
	private Integer roleId;				//角色编号
	private String roleName;			//角色名称
	private Integer roleJurisdiction;	//角色重要度 0表示一般可删除 1.表示重要不可删除，
	private String roleRemark;			//角色备注
	private Integer roleStatu;			//角色状态 0.启用 1不启用
	private Integer roleFirstpageId;	//首页
	
	private Integer clientId;			//公司编号  0后台管理角色
	
	private String ext1;
	private String ext2;
	private String ext3;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	@Column(length=100)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Column
	public Integer getRoleJurisdiction() {
		return roleJurisdiction;
	}
	public void setRoleJurisdiction(Integer roleJurisdiction) {
		this.roleJurisdiction = roleJurisdiction;
	}
	
	@Column(length=100)
	public String getRoleRemark() {
		return roleRemark;
	}
	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0") 
	public Integer getRoleStatu() {
		return roleStatu;
	}
	public void setRoleStatu(Integer roleStatu) {
		this.roleStatu = roleStatu;
	}
	
	@Column
	public Integer getRoleFirstpageId() {
		return roleFirstpageId;
	}
	public void setRoleFirstpageId(Integer roleFirstpageId) {
		this.roleFirstpageId = roleFirstpageId;
	}
	
	@Column(length=100)
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	
	@Column(length=100)
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	
	@Column(length=100)
	public String getExt3() {
		return ext3;
	}
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	
	@Column
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
}


