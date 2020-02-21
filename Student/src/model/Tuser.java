package model;

/**
 * Tuser entity. @author MyEclipse Persistence Tools
 */

public class Tuser implements java.io.Serializable {

	// Fields

	private String userid;
	private String account;
	private String pwd;
	private Integer roleId;
	private Integer isDel;
	private Boolean usertype;

	// Constructors

	/** default constructor */
	public Tuser() {
	}

	/** minimal constructor */
	public Tuser(String userid, String account, String pwd) {
		this.userid = userid;
		this.account = account;
		this.pwd = pwd;
	}

	/** full constructor */
	public Tuser(String userid, String account, String pwd, Integer roleId,
			Integer isDel, Boolean usertype) {
		this.userid = userid;
		this.account = account;
		this.pwd = pwd;
		this.roleId = roleId;
		this.isDel = isDel;
		this.usertype = usertype;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Boolean getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Boolean usertype) {
		this.usertype = usertype;
	}

}