package model;

/**
 * VAdminUser entity. @author MyEclipse Persistence Tools
 */

public class VAdminUser implements java.io.Serializable {

	// Fields

		private String userid;
		private String account;
		private String pwd;
		private Integer roleId;
		private Integer isDel;
		private String roleName;
		private String remark;

		// Constructors

		/** default constructor */
		public VAdminUser() {
		}

		/** minimal constructor */
		public VAdminUser(String userid, String account, String pwd) {
			this.userid = userid;
			this.account = account;
			this.pwd = pwd;
		}

		/** full constructor */
		public VAdminUser(String userid, String account, String pwd,
				Integer roleId, Integer isDel, String roleName, String remark) {
			this.userid = userid;
			this.account = account;
			this.pwd = pwd;
			this.roleId = roleId;
			this.isDel = isDel;
			this.roleName = roleName;
			this.remark = remark;
		}

		// Property accessors

		public String getUserid() {
			return this.userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getAccount() {
			return this.account;
		}

		public void setAccount(String account) {
			this.account = account;
		}

		public String getPwd() {
			return this.pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public Integer getRoleId() {
			return this.roleId;
		}

		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}

		public Integer getIsDel() {
			return this.isDel;
		}

		public void setIsDel(Integer isDel) {
			this.isDel = isDel;
		}

		public String getRoleName() {
			return this.roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}

		public String getRemark() {
			return this.remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

}