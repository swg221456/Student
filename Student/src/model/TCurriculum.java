package model;

/**
 * TCurriculum entity. @author MyEclipse Persistence Tools
 */

public class TCurriculum implements java.io.Serializable {

	// Fields

	private Integer curriculumid;
	private String curriculumName;
	private Integer semesterid;
	private String introduce;
	private String remarks;
	private Integer isdelete;

	// Constructors

	/** default constructor */
	public TCurriculum() {
	}

	/** minimal constructor */
	public TCurriculum(Integer isdelete) {
		this.isdelete = isdelete;
	}

	/** full constructor */
	public TCurriculum(String curriculumName, Integer semesterid,
			String introduce, String remarks, Integer isdelete) {
		this.curriculumName = curriculumName;
		this.semesterid = semesterid;
		this.introduce = introduce;
		this.remarks = remarks;
		this.isdelete = isdelete;
	}

	// Property accessors

	public Integer getCurriculumid() {
		return this.curriculumid;
	}

	public void setCurriculumid(Integer curriculumid) {
		this.curriculumid = curriculumid;
	}

	public String getCurriculumName() {
		return this.curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}

	public Integer getSemesterid() {
		return this.semesterid;
	}

	public void setSemesterid(Integer semesterid) {
		this.semesterid = semesterid;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

}