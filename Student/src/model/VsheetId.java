package model;

/**
 * VsheetId entity. @author MyEclipse Persistence Tools
 */

public class VsheetId implements java.io.Serializable {

	// Fields

	private Integer sheetid;
	private Integer courseid;
	private Integer stuinfoid;
	private Double fraction;
	private String evaluate;
	private Integer isdelete;
	private Integer curriculumid;
	private Integer teacherid;
	private String teaName;
	private String curriculumName;
	private String semesterName;
	private String introduce;
	private String stuname;
	private String stunum;
	private String agend;
	private String phone;
	private Integer classid;
	private Integer collegeid;
	private String collegeName;
	private Integer majorid;
	private String majorName;
	private String className;
	private Integer semesterid;
	private String userid;

	// Constructors

	/** default constructor */
	public VsheetId() {
	}

	/** minimal constructor */
	public VsheetId(Integer sheetid, Integer isdelete, Integer classid,
			Integer collegeid, String collegeName, Integer majorid,
			String majorName, String className, Integer semesterid) {
		this.sheetid = sheetid;
		this.isdelete = isdelete;
		this.classid = classid;
		this.collegeid = collegeid;
		this.collegeName = collegeName;
		this.majorid = majorid;
		this.majorName = majorName;
		this.className = className;
		this.semesterid = semesterid;
	}

	/** full constructor */
	public VsheetId(Integer sheetid, Integer courseid, Integer stuinfoid,
			Double fraction, String evaluate, Integer isdelete,
			Integer curriculumid, Integer teacherid, String teaName,
			String curriculumName, String semesterName, String introduce,
			String stuname, String stunum, String agend, String phone,
			Integer classid, Integer collegeid, String collegeName,
			Integer majorid, String majorName, String className,
			Integer semesterid, String userid) {
		this.sheetid = sheetid;
		this.courseid = courseid;
		this.stuinfoid = stuinfoid;
		this.fraction = fraction;
		this.evaluate = evaluate;
		this.isdelete = isdelete;
		this.curriculumid = curriculumid;
		this.teacherid = teacherid;
		this.teaName = teaName;
		this.curriculumName = curriculumName;
		this.semesterName = semesterName;
		this.introduce = introduce;
		this.stuname = stuname;
		this.stunum = stunum;
		this.agend = agend;
		this.phone = phone;
		this.classid = classid;
		this.collegeid = collegeid;
		this.collegeName = collegeName;
		this.majorid = majorid;
		this.majorName = majorName;
		this.className = className;
		this.semesterid = semesterid;
		this.userid = userid;
	}

	// Property accessors

	public Integer getSheetid() {
		return this.sheetid;
	}

	public void setSheetid(Integer sheetid) {
		this.sheetid = sheetid;
	}

	public Integer getCourseid() {
		return this.courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public Integer getStuinfoid() {
		return this.stuinfoid;
	}

	public void setStuinfoid(Integer stuinfoid) {
		this.stuinfoid = stuinfoid;
	}

	public Double getFraction() {
		return this.fraction;
	}

	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

	public String getEvaluate() {
		return this.evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
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

	public String getTeaName() {
		return this.teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getCurriculumName() {
		return this.curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}

	public String getSemesterName() {
		return this.semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getStuname() {
		return this.stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStunum() {
		return this.stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
	}

	public String getAgend() {
		return this.agend;
	}

	public void setAgend(String agend) {
		this.agend = agend;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

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

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getSemesterid() {
		return this.semesterid;
	}

	public void setSemesterid(Integer semesterid) {
		this.semesterid = semesterid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VsheetId))
			return false;
		VsheetId castOther = (VsheetId) other;

		return ((this.getSheetid() == castOther.getSheetid()) || (this
				.getSheetid() != null && castOther.getSheetid() != null && this
				.getSheetid().equals(castOther.getSheetid())))
				&& ((this.getCourseid() == castOther.getCourseid()) || (this
						.getCourseid() != null
						&& castOther.getCourseid() != null && this
						.getCourseid().equals(castOther.getCourseid())))
				&& ((this.getStuinfoid() == castOther.getStuinfoid()) || (this
						.getStuinfoid() != null
						&& castOther.getStuinfoid() != null && this
						.getStuinfoid().equals(castOther.getStuinfoid())))
				&& ((this.getFraction() == castOther.getFraction()) || (this
						.getFraction() != null
						&& castOther.getFraction() != null && this
						.getFraction().equals(castOther.getFraction())))
				&& ((this.getEvaluate() == castOther.getEvaluate()) || (this
						.getEvaluate() != null
						&& castOther.getEvaluate() != null && this
						.getEvaluate().equals(castOther.getEvaluate())))
				&& ((this.getIsdelete() == castOther.getIsdelete()) || (this
						.getIsdelete() != null
						&& castOther.getIsdelete() != null && this
						.getIsdelete().equals(castOther.getIsdelete())))
				&& ((this.getCurriculumid() == castOther.getCurriculumid()) || (this
						.getCurriculumid() != null
						&& castOther.getCurriculumid() != null && this
						.getCurriculumid().equals(castOther.getCurriculumid())))
				&& ((this.getTeacherid() == castOther.getTeacherid()) || (this
						.getTeacherid() != null
						&& castOther.getTeacherid() != null && this
						.getTeacherid().equals(castOther.getTeacherid())))
				&& ((this.getTeaName() == castOther.getTeaName()) || (this
						.getTeaName() != null && castOther.getTeaName() != null && this
						.getTeaName().equals(castOther.getTeaName())))
				&& ((this.getCurriculumName() == castOther.getCurriculumName()) || (this
						.getCurriculumName() != null
						&& castOther.getCurriculumName() != null && this
						.getCurriculumName().equals(
								castOther.getCurriculumName())))
				&& ((this.getSemesterName() == castOther.getSemesterName()) || (this
						.getSemesterName() != null
						&& castOther.getSemesterName() != null && this
						.getSemesterName().equals(castOther.getSemesterName())))
				&& ((this.getIntroduce() == castOther.getIntroduce()) || (this
						.getIntroduce() != null
						&& castOther.getIntroduce() != null && this
						.getIntroduce().equals(castOther.getIntroduce())))
				&& ((this.getStuname() == castOther.getStuname()) || (this
						.getStuname() != null && castOther.getStuname() != null && this
						.getStuname().equals(castOther.getStuname())))
				&& ((this.getStunum() == castOther.getStunum()) || (this
						.getStunum() != null && castOther.getStunum() != null && this
						.getStunum().equals(castOther.getStunum())))
				&& ((this.getAgend() == castOther.getAgend()) || (this
						.getAgend() != null && castOther.getAgend() != null && this
						.getAgend().equals(castOther.getAgend())))
				&& ((this.getPhone() == castOther.getPhone()) || (this
						.getPhone() != null && castOther.getPhone() != null && this
						.getPhone().equals(castOther.getPhone())))
				&& ((this.getClassid() == castOther.getClassid()) || (this
						.getClassid() != null && castOther.getClassid() != null && this
						.getClassid().equals(castOther.getClassid())))
				&& ((this.getCollegeid() == castOther.getCollegeid()) || (this
						.getCollegeid() != null
						&& castOther.getCollegeid() != null && this
						.getCollegeid().equals(castOther.getCollegeid())))
				&& ((this.getCollegeName() == castOther.getCollegeName()) || (this
						.getCollegeName() != null
						&& castOther.getCollegeName() != null && this
						.getCollegeName().equals(castOther.getCollegeName())))
				&& ((this.getMajorid() == castOther.getMajorid()) || (this
						.getMajorid() != null && castOther.getMajorid() != null && this
						.getMajorid().equals(castOther.getMajorid())))
				&& ((this.getMajorName() == castOther.getMajorName()) || (this
						.getMajorName() != null
						&& castOther.getMajorName() != null && this
						.getMajorName().equals(castOther.getMajorName())))
				&& ((this.getClassName() == castOther.getClassName()) || (this
						.getClassName() != null
						&& castOther.getClassName() != null && this
						.getClassName().equals(castOther.getClassName())))
				&& ((this.getSemesterid() == castOther.getSemesterid()) || (this
						.getSemesterid() != null
						&& castOther.getSemesterid() != null && this
						.getSemesterid().equals(castOther.getSemesterid())))
				&& ((this.getUserid() == castOther.getUserid()) || (this
						.getUserid() != null && castOther.getUserid() != null && this
						.getUserid().equals(castOther.getUserid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSheetid() == null ? 0 : this.getSheetid().hashCode());
		result = 37 * result
				+ (getCourseid() == null ? 0 : this.getCourseid().hashCode());
		result = 37 * result
				+ (getStuinfoid() == null ? 0 : this.getStuinfoid().hashCode());
		result = 37 * result
				+ (getFraction() == null ? 0 : this.getFraction().hashCode());
		result = 37 * result
				+ (getEvaluate() == null ? 0 : this.getEvaluate().hashCode());
		result = 37 * result
				+ (getIsdelete() == null ? 0 : this.getIsdelete().hashCode());
		result = 37
				* result
				+ (getCurriculumid() == null ? 0 : this.getCurriculumid()
						.hashCode());
		result = 37 * result
				+ (getTeacherid() == null ? 0 : this.getTeacherid().hashCode());
		result = 37 * result
				+ (getTeaName() == null ? 0 : this.getTeaName().hashCode());
		result = 37
				* result
				+ (getCurriculumName() == null ? 0 : this.getCurriculumName()
						.hashCode());
		result = 37
				* result
				+ (getSemesterName() == null ? 0 : this.getSemesterName()
						.hashCode());
		result = 37 * result
				+ (getIntroduce() == null ? 0 : this.getIntroduce().hashCode());
		result = 37 * result
				+ (getStuname() == null ? 0 : this.getStuname().hashCode());
		result = 37 * result
				+ (getStunum() == null ? 0 : this.getStunum().hashCode());
		result = 37 * result
				+ (getAgend() == null ? 0 : this.getAgend().hashCode());
		result = 37 * result
				+ (getPhone() == null ? 0 : this.getPhone().hashCode());
		result = 37 * result
				+ (getClassid() == null ? 0 : this.getClassid().hashCode());
		result = 37 * result
				+ (getCollegeid() == null ? 0 : this.getCollegeid().hashCode());
		result = 37
				* result
				+ (getCollegeName() == null ? 0 : this.getCollegeName()
						.hashCode());
		result = 37 * result
				+ (getMajorid() == null ? 0 : this.getMajorid().hashCode());
		result = 37 * result
				+ (getMajorName() == null ? 0 : this.getMajorName().hashCode());
		result = 37 * result
				+ (getClassName() == null ? 0 : this.getClassName().hashCode());
		result = 37
				* result
				+ (getSemesterid() == null ? 0 : this.getSemesterid()
						.hashCode());
		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		return result;
	}

}