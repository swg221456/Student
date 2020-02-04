package model;

/**
 * Vsheet entity. @author MyEclipse Persistence Tools
 */

public class Vsheet implements java.io.Serializable {

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

		// Constructors

		/** default constructor */
		public Vsheet() {
		}

		/** minimal constructor */
		public Vsheet(Integer sheetid, Integer isdelete, Integer classid,
				Integer collegeid, String collegeName, Integer majorid,
				String majorName, String className) {
			this.sheetid = sheetid;
			this.isdelete = isdelete;
			this.classid = classid;
			this.collegeid = collegeid;
			this.collegeName = collegeName;
			this.majorid = majorid;
			this.majorName = majorName;
			this.className = className;
		}

		/** full constructor */
		public Vsheet(Integer sheetid, Integer courseid, Integer stuinfoid,
				Double fraction, String evaluate, Integer isdelete,
				Integer curriculumid, Integer teacherid, String teaName,
				String curriculumName, String semesterName, String introduce,
				String stuname, String stunum, String agend, String phone,
				Integer classid, Integer collegeid, String collegeName,
				Integer majorid, String majorName, String className) {
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

}