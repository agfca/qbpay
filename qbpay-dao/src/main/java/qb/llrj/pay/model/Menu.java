package qb.llrj.pay.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName:			Menu
 * @Description:		菜单信息类
 * @author:          	OuYao
 * @date:    			2019年1月4日  上午10:37:05
 */
@Entity
@Table(name="menu")
public class Menu implements Serializable  {

	/**
	 *
	 */
	private static final long serialVersionUID = 2278443710960735413L;

	private Integer menuId;				//菜单编号
	private Integer menuParentId;		//上级菜单编号
	private String menuName;			//菜单名称
	private String menuUrl;				//菜单地址
	private Integer menuLevel;			//菜单级别
	private String menuRemark;			//菜单备注
	private Integer menuStatu;			//菜单状态 0启用，1不启用
	
	private String menuIcon;			//菜单图标
	
	private String ext1;
	private String ext2;
	private String ext3;
	
	private Integer menuType;			//菜单类型 0前端 1后台 2公用
	
	private String menuParentName;		//上级菜单名称
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	@Column
	public Integer getMenuParentId() {
		return menuParentId;
	}
	public void setMenuParentId(Integer menuParentId) {
		this.menuParentId = menuParentId;
	}
	
	@Column(length=50)
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	@Column(length=100)
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	@Column
	public Integer getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	
	@Column(length=100)
	public String getMenuRemark() {
		return menuRemark;
	}
	public void setMenuRemark(String menuRemark) {
		this.menuRemark = menuRemark;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0") 
	public Integer getMenuStatu() {
		return menuStatu;
	}
	public void setMenuStatu(Integer menuStatu) {
		this.menuStatu = menuStatu;
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
	
	@Column(length=100)
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	
	@Column(length=100)
	public String getMenuParentName() {
		return menuParentName;
	}
	public void setMenuParentName(String menuParentName) {
		this.menuParentName = menuParentName;
	}
	
	@Column
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
}


