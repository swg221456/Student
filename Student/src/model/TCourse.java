package model;

/**
 * TCourse entity. @author MyEclipse Persistence Tools
 */

public class TCourse implements java.io.Serializable {

	// Fields

	private Integer courseid;
	private Integer curriculumid;
	private Integer teacherid;
	private Integer classid;
	private String remakes;
	private Integer isdelete;

	// Constructors

	/** default constructor */
	public TCourse() {
	}

	/** minimal constructor */
	public TCourse(Integer isdelete) {
		this.isdelete = isdelete;
	}

	/** full constructor */
	public TCourse(Integer curriculumid, Integer teacherid, Integer classid,
			String remakes, Integer isdelete) {
		this.curriculumid = curriculumid;
		this.teacherid = teacherid;
		this.classid = classid;
		this.remakes = remakes;
		this.isdelete = isdelete;
	}

	// Property accessors

	public Integer getCourseid() {
		return this.courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public Integer getCurriculumid() {
		return this.curriculumid;
	}

	public void setCurriculumid(Integer curriculumid) {
		this.curriculumid = curriculumid;
	}

	public Integer getTeacherid() {
		return this.teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getRemakes() {
		return this.remakes;
	}

	public void setRemakes(String remakes) {
		this.remakes = remakes;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

}