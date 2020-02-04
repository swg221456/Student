package model;

/**
 * Vmajor entity. @author MyEclipse Persistence Tools
 */

public class Vmajor implements java.io.Serializable {

	// Fields

		private String collegeName;
		private String majorName;
		private Integer majorid;
		private Integer collegeid;
		private String userid;
		private Integer isdelete;

		// Constructors

		/** default constructor */
		public Vmajor() {
		}

		/** minimal constructor */
		public Vmajor(String collegeName, String majorName, Integer majorid) {
			this.collegeName = collegeName;
			this.majorName = majorName;
			this.majorid = majorid;
		}

		/** full constructor */
		public Vmajor(String collegeName, String majorName, Integer majorid,
				Integer collegeid, String userid, Integer isdelete) {
			this.collegeName = collegeName;
			this.majorName = majorName;
			this.majorid = majorid;
			this.collegeid = collegeid;
			this.userid = userid;
			this.isdelete = isdelete;
		}

		// Property accessors

		public String getCollegeName() {
			return this.collegeName;
		}

		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}

		public String getMajorName() {
			return this.majorName;
		}

		public void setMajorName(String majorName) {
			this.majorName = majorName;
		}

		public Integer getMajorid() {
			return this.majorid;
		}

		public void setMajorid(Integer majorid) {
			this.majorid = majorid;
		}

		public Integer getCollegeid() {
			return this.collegeid;
		}

		public void setCollegeid(Integer collegeid) {
			this.collegeid = collegeid;
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