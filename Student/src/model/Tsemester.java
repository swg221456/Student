package model;



/**
 * Tsemester entity. @author MyEclipse Persistence Tools
 */

public class Tsemester implements java.io.Serializable {

	// Fields

	private Integer semesterid;
	private String semesterName;
	private String startdate;
	private String enddate;
	private Integer isdelete;

	// Constructors

	/** default constructor */
	public Tsemester() {
	}

	/** minimal constructor */
	public Tsemester(Integer isdelete) {
		this.isdelete = isdelete;
	}

	/** full constructor */
	public Tsemester(String semesterName, String startdate,
			String enddate, Integer isdelete) {
		this.semesterName = semesterName;
		this.startdate = startdate;
		this.enddate = enddate;
		this.isdelete = isdelete;
	}

	// Property accessors

	public Integer getSemesterid() {
		return this.semesterid;
	}

	public void setSemesterid(Integer semesterid) {
		this.semesterid = semesterid;
	}

	public String getSemesterName() {
		return this.semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public String getStartdate() {
		return util.ReturnDate.datetimeFormatnotime(this.startdate);
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return util.ReturnDate.datetimeFormatnotime(this.enddate);
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

}