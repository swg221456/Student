package model;

/**
 * TroleB entity. @author MyEclipse Persistence Tools
 */

public class TroleB implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String remark;
	private Integer isDel;

	// Constructors

	/** default constructor */
	public TroleB() {
	}

	/** minimal constructor */
	public TroleB(Integer isDel) {
		this.isDel = isDel;
	}

	/** full constructor */
	public TroleB(String roleName, String remark, Integer isDel) {
		this.roleName = roleName;
		this.remark = remark;
		this.isDel = isDel;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}