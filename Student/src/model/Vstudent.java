package model;


/**
 * Vstudent entity. @author MyEclipse Persistence Tools
 */

public class Vstudent implements java.io.Serializable {

	// Fields

		private Integer stuinfoid;
		private String stuname;
		private String stunum;
		private String agend;
		private String birthday;
		private String phone;
		private String email;
		private String userid;
		private Integer classid;
		private Integer isdelete;
		private String stucard;
		private Integer collegeid;
		private String collegeName;
		private Integer majorid;
		private String majorName;
		private String className;

		// Constructors

		/** default constructor */
		public Vstudent() {
		}

		/** minimal constructor */
		public Vstudent(Integer stuinfoid, Integer classid, Integer collegeid,
				String collegeName, Integer majorid, String majorName,
				String className) {
			this.stuinfoid = stuinfoid;
			this.classid = classid;
			this.collegeid = collegeid;
			this.collegeName = collegeName;
			this.majorid = majorid;
			this.majorName = majorName;
			this.className = className;
		}

		/** full constructor */
		public Vstudent(Integer stuinfoid, String stuname, String stunum,
				String agend, String birthday, String phone, String email,
				String userid, Integer classid, Integer isdelete, String stucard,
				Integer collegeid, String collegeName, Integer majorid,
				String majorName, String className) {
			this.stuinfoid = stuinfoid;
			this.stuname = stuname;
			this.stunum = stunum;
			this.agend = agend;
			this.birthday = birthday;
			this.phone = phone;
			this.email = email;
			this.userid = userid;
			this.classid = classid;
			this.isdelete = isdelete;
			this.stucard = stucard;
			this.collegeid = collegeid;
			this.collegeName = collegeName;
			this.majorid = majorid;
			this.majorName = majorName;
			this.className = className;
		}

		// Property accessors

		public Integer getStuinfoid() {
			return this.stuinfoid;
		}

		public void setStuinfoid(Integer stuinfoid) {
			this.stuinfoid = stuinfoid;
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

		public String getBirthday() {
			return util.ReturnDate.datetimeFormatnotime(this.birthday) ;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public String getPhone() {
			return this.phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return this.email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUserid() {
			return this.userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public Integer getClassid() {
			return this.classid;
		}

		public void setClassid(Integer classid) {
			this.classid = classid;
		}

		public Integer getIsdelete() {
			return this.isdelete;
		}

		public void setIsdelete(Integer isdelete) {
			this.isdelete = isdelete;
		}

		public String getStucard() {
			return this.stucard;
		}

		public void setStucard(String stucard) {
			this.stucard = stucard;
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