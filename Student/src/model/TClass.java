package model;

/**
 * TClass entity. @author MyEclipse Persistence Tools
 */

public class TClass implements java.io.Serializable {

	// Fields

	private Integer classid;
	private String className;
	private Integer majorid;
	private String userid;
	private Integer isdelete;

	// Constructors

	/** default constructor */
	public TClass() {
	}

	/** minimal constructor */
	public TClass(String className, Integer isdelete) {
		this.className = className;
		this.isdelete = isdelete;
	}

	/** full constructor */
	public TClass(String className, Integer majorid, String userid,
			Integer isdelete) {
		this.className = className;
		this.majorid = majorid;
		this.userid = userid;
		this.isdelete = isdelete;
	}

	// Property accessors

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getMajorid() {
		return this.majorid;
	}

	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
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