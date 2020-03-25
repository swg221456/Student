package model;

/**
 * TphotoInfo entity. @author MyEclipse Persistence Tools
 */

public class TphotoInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String photopath;
	private Integer isDel;

	// Constructors

	/** default constructor */
	public TphotoInfo() {
	}

	/** full constructor */
	public TphotoInfo(String photopath, Integer isDel) {
		this.photopath = photopath;
		this.isDel = isDel;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhotopath() {
		return this.photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}