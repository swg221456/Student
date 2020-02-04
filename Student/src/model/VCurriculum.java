package model;



/**
 * VCurriculum entity. @author MyEclipse Persistence Tools
 */

public class VCurriculum implements java.io.Serializable {

	// Fields

		private Integer curriculumid;
		private String curriculumName;
		private Integer semesterid;
		private String introduce;
		private String remarks;
		private Integer isdelete;
		private String semesterName;
		private String startdate;
		private String enddate;

		// Constructors

		/** default constructor */
		public VCurriculum() {
		}

		/** minimal constructor */
		public VCurriculum(Integer curriculumid, Integer isdelete) {
			this.curriculumid = curriculumid;
			this.isdelete = isdelete;
		}

		/** full constructor */
		public VCurriculum(Integer curriculumid, String curriculumName,
				Integer semesterid, String introduce, String remarks,
				Integer isdelete, String semesterName, String startdate,
				String enddate) {
			this.curriculumid = curriculumid;
			this.curriculumName = curriculumName;
			this.semesterid = semesterid;
			this.introduce = introduce;
			this.remarks = remarks;
			this.isdelete = isdelete;
			this.semesterName = semesterName;
			this.startdate = startdate;
			this.enddate = enddate;
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

}