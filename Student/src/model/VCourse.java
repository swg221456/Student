package model;

/**
 * VCourse entity. @author MyEclipse Persistence Tools
 */

public class VCourse implements java.io.Serializable {

	// Fields

		private Integer courseid;
		private Integer curriculumid;
		private Integer teacherid;
		private Integer classid;
		private String remakes;
		private Integer isdelete;
		private String className;
		private String teaName;
		private String curriculumName;
		private String introduce;
		private String semesterName;

		// Constructors

		/** default constructor */
		public VCourse() {
		}

		/** minimal constructor */
		public VCourse(Integer courseid, Integer isdelete, String className) {
			this.courseid = courseid;
			this.isdelete = isdelete;
			this.className = className;
		}

		/** full constructor */
		public VCourse(Integer courseid, Integer curriculumid, Integer teacherid,
				Integer classid, String remakes, Integer isdelete,
				String className, String teaName, String curriculumName,
				String introduce, String semesterName) {
			this.courseid = courseid;
			this.curriculumid = curriculumid;
			this.teacherid = teacherid;
			this.classid = classid;
			this.remakes = remakes;
			this.isdelete = isdelete;
			this.className = className;
			this.teaName = teaName;
			this.curriculumName = curriculumName;
			this.introduce = introduce;
			this.semesterName = semesterName;
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

		public String getClassName() {
			return this.className;
		}

		public void setClassName(String className) {
			this.className = className;
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

		public String getIntroduce() {
			return this.introduce;
		}

		public void setIntroduce(String introduce) {
			this.introduce = introduce;
		}

		public String getSemesterName() {
			return this.semesterName;
		}

		public void setSemesterName(String semesterName) {
			this.semesterName = semesterName;
		}

}