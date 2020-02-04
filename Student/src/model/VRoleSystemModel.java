package model;

/**
 * VRoleSystemModel entity. @author MyEclipse Persistence Tools
 */

public class VRoleSystemModel implements java.io.Serializable {

	// Fields

		private Integer id;
		private Integer roleId;
		private Integer sysid;
		private Boolean isedit;
		private Boolean isdelete;
		private String createdate;
		private String name;
		private String chinesename;
		private String navurl;
		private Integer deepth;
		private Integer parentid;
		private Integer displayorder;
		private String imageurl;
		private String roleName;
		private String remark;

		// Constructors

		/** default constructor */
		public VRoleSystemModel() {
		}

		/** minimal constructor */
		public VRoleSystemModel(Integer id, Integer roleId, Integer sysid,
				Boolean isedit,Boolean isdelete) {
			this.id = id;
			this.roleId = roleId;
			this.sysid = sysid;
			this.isedit = isedit;
			this.isdelete = isdelete;
		}

		/** full constructor */
		public VRoleSystemModel(Integer id, Integer roleId, Integer sysid,
				Boolean isedit,Boolean isdelete, String createdate, String name,
				String chinesename, String navurl, Integer deepth,
				Integer parentid, Integer displayorder, String imageurl,
				String roleName, String remark) {
			this.id = id;
			this.roleId = roleId;
			this.sysid = sysid;
			this.isedit = isedit;
			this.isdelete = isdelete;
			this.createdate = createdate;
			this.name = name;
			this.chinesename = chinesename;
			this.navurl = navurl;
			this.deepth = deepth;
			this.parentid = parentid;
			this.displayorder = displayorder;
			this.imageurl = imageurl;
			this.roleName = roleName;
			this.remark = remark;
		}

		// Property accessors

		public Integer getId() {
			return this.id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getRoleId() {
			return this.roleId;
		}

		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}

		public Integer getSysid() {
			return this.sysid;
		}

		public void setSysid(Integer sysid) {
			this.sysid = sysid;
		}

		public Boolean getIsedit() {
			return this.isedit;
		}

		public void setIsedit(Boolean isedit) {
			this.isedit = isedit;
		}
		
		public Boolean getIsdelete() {
			return this.isdelete;
		}

		public void setIsdelete(Boolean isdelete) {
			this.isdelete = isdelete;
		}

		public String getCreatedate() {
			return this.createdate;
		}

		public void setCreatedate(String createdate) {
			this.createdate = createdate;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getChinesename() {
			return this.chinesename;
		}

		public void setChinesename(String chinesename) {
			this.chinesename = chinesename;
		}

		public String getNavurl() {
			return this.navurl;
		}

		public void setNavurl(String navurl) {
			this.navurl = navurl;
		}

		public Integer getDeepth() {
			return this.deepth;
		}

		public void setDeepth(Integer deepth) {
			this.deepth = deepth;
		}

		public Integer getParentid() {
			return this.parentid;
		}

		public void setParentid(Integer parentid) {
			this.parentid = parentid;
		}

		public Integer getDisplayorder() {
			return this.displayorder;
		}

		public void setDisplayorder(Integer displayorder) {
			this.displayorder = displayorder;
		}

		public String getImageurl() {
			return this.imageurl;
		}

		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
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