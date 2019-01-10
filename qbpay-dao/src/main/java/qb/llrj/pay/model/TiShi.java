package qb.llrj.pay.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 

/**
 * The persistent class for the CardType database table.
 * 
 */
@Entity
@Table(name="tishi")
 public class TiShi implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String ext;
	private int typeid;
	private String typename;
	private int status;//0, 1
	private String remark;

    public TiShi() {
    }
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
 	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(length=50)
 	public String getExt() {
		return this.ext;
	}
	@Column 
 	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	
	@Column(length=50)
	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	@Column(nullable=false,columnDefinition="INT default 0") 
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	@Column(length=50)
 	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	 


}