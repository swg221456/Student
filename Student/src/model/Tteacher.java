package model;

/**
 * Tteacher entity. @author MyEclipse Persistence Tools
 */

public class Tteacher implements java.io.Serializable {

	// Fields

	private Integer teacherid;
	private String teaName;
	private String teaphone;
	private String userid;
	private String teasex;
	private Boolean auditstatus;
	private Integer isdelete;

	// Constructors

	/** default constructor */
	public Tteacher() {
	}

	/** full constructor */
	public Tteacher(String teaName, String teaphone, String userid,
			String teasex, Boolean auditstatus, Integer isdelete) {
		this.teaName = teaName;
		this.teaphone = teaphone;
		this.userid = userid;
		this.teasex = teasex;
		this.auditstatus = auditstatus;
		this.isdelete = isdelete;
	}

	// Property accessors

	public Integer getTeacherid() {
		return this.teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeaName() {
		return this.teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaphone() {
		return this.teaphone;
	}

	public void setTeaphone(String teaphone) {
		this.teaphone = teaphone;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTeasex() {
		return this.teasex;
	}

	public void setTeasex(String teasex) {
		this.teasex = teasex;
	}

	public Boolean getAuditstatus() {
		return this.auditstatus;
	}

	public void setAuditstatus(Boolean auditstatus) {
		this.auditstatus = auditstatus;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

}