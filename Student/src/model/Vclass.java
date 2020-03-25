package model;

/**
 * Vclass entity. @author MyEclipse Persistence Tools
 */

public class Vclass implements java.io.Serializable {

	// Fields

		private Integer classid;
		private String className;
		private Integer majorid;
		private String userid;
		private Integer isdelete;
		private String majorName;
		private String collegeName;
		private Integer collegeid;

		// Constructors

		/** default constructor */
		public Vclass() {
		}

		/** minimal constructor */
		public Vclass(Integer classid, String className, Integer isdelete,
				String majorName, String collegeName, Integer collegeid) {
			this.classid = classid;
			this.className = className;
			this.isdelete = isdelete;
			this.majorName = majorName;
			this.collegeName = collegeName;
			this.collegeid = collegeid;
		}

		/** full constructor */
		public Vclass(Integer classid, String className, Integer majorid,
				String userid, Integer isdelete, String majorName,
				String collegeName, Integer collegeid) {
			this.classid = classid;
			this.className = className;
			this.majorid = majorid;
			this.userid = userid;
			this.isdelete = isdelete;
			this.majorName = majorName;
			this.collegeName = collegeName;
			this.collegeid = collegeid;
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

		public String getMajorName() {
			return this.majorName;
		}

		public void setMajorName(String majorName) {
			this.majorName = majorName;
		}

		public String getCollegeName() {
			return this.collegeName;
		}

		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}

		public Integer getCollegeid() {
			return this.collegeid;
		}

		public void setCollegeid(Integer collegeid) {
			this.collegeid = collegeid;
		}

}