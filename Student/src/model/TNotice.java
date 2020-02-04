package model;


/**
 * TNotice entity. @author MyEclipse Persistence Tools
 */

public class TNotice implements java.io.Serializable {

	// Fields

	private Integer noticeid;
	private String noticeName;
	private String noticecontent;
	private String remarks;
	private String userid;
	private String createdate;
	private Integer isdelete;

	// Constructors

	/** default constructor */
	public TNotice() {
	}

	/** minimal constructor */
	public TNotice(String noticeName, String noticecontent, String userid,
			String createdate, Integer isdelete) {
		this.noticeName = noticeName;
		this.noticecontent = noticecontent;
		this.userid = userid;
		this.createdate = createdate;
		this.isdelete = isdelete;
	}

	/** full constructor */
	public TNotice(String noticeName, String noticecontent, String remarks,
			String userid, String createdate, Integer isdelete) {
		this.noticeName = noticeName;
		this.noticecontent = noticecontent;
		this.remarks = remarks;
		this.userid = userid;
		this.createdate = createdate;
		this.isdelete = isdelete;
	}

	// Property accessors

	public Integer getNoticeid() {
		return this.noticeid;
	}

	public void setNoticeid(Integer noticeid) {
		this.noticeid = noticeid;
	}

	public String getNoticeName() {
		return this.noticeName;
	}

	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}

	public String getNoticecontent() {
		return this.noticecontent;
	}

	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCreatedate() {
		return util.ReturnDate.datetimeFormatnotime(this.createdate);
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

}