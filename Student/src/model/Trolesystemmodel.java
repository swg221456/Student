package model;

import java.sql.Timestamp;

/**
 * Trolesystemmodel entity. @author MyEclipse Persistence Tools
 */

public class Trolesystemmodel implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleId;
	private Integer sysid;
	private Boolean isedit;
	private String createdate;

	// Constructors

	/** default constructor */
	public Trolesystemmodel() {
	}

	/** minimal constructor */
	public Trolesystemmodel(Integer roleId, Integer sysid, Boolean isedit) {
		this.roleId = roleId;
		this.sysid = sysid;
		this.isedit = isedit;
	}

	/** full constructor */
	public Trolesystemmodel(Integer roleId, Integer sysid, Boolean isedit,
			String createdate) {
		this.roleId = roleId;
		this.sysid = sysid;
		this.isedit = isedit;
		this.createdate = createdate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getSysid() {
		return this.sysid;
	}

	public void setSysid(Integer sysid) {
		this.sysid = sysid;
	}

	public Boolean getIsedit() {
		return this.isedit;
	}

	public void setIsedit(Boolean isedit) {
		this.isedit = isedit;
	}

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

}