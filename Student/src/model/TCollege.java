package model;

/**
 * TCollege entity. @author MyEclipse Persistence Tools
 */

public class TCollege implements java.io.Serializable {

	// Fields

	private Integer collegeid;
	private String collegeName;
	private String userid;
	private Integer isdelete;

	// Constructors

	/** default constructor */
	public TCollege() {
	}

	/** minimal constructor */
	public TCollege(String collegeName, Integer isdelete) {
		this.collegeName = collegeName;
		this.isdelete = isdelete;
	}

	/** full constructor */
	public TCollege(String collegeName, String userid, Integer isdelete) {
		this.collegeName = collegeName;
		this.userid = userid;
		this.isdelete = isdelete;
	}

	// Property accessors

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
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