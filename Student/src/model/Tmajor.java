package model;

/**
 * Tmajor entity. @author MyEclipse Persistence Tools
 */

public class Tmajor implements java.io.Serializable {

	// Fields

	private Integer majorid;
	private String majorName;
	private Integer collegeid;
	private String userid;
	private Integer isdelete;

	// Constructors

	/** default constructor */
	public Tmajor() {
	}

	/** minimal constructor */
	public Tmajor(String majorName) {
		this.majorName = majorName;
	}

	/** full constructor */
	public Tmajor(String majorName, Integer collegeid, String userid,
			Integer isdelete) {
		this.majorName = majorName;
		this.collegeid = collegeid;
		this.userid = userid;
		this.isdelete = isdelete;
	}

	// Property accessors

	public Integer getMajorid() {
		return this.majorid;
	}

	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

}