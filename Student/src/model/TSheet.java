package model;

/**
 * TSheet entity. @author MyEclipse Persistence Tools
 */

public class TSheet implements java.io.Serializable {

	// Fields

	private Integer sheetid;
	private Integer courseid;
	private Integer stuinfoid;
	private Double fraction;
	private String evaluate;
	private Integer isdelete;
	private String remakes;

	// Constructors

	/** default constructor */
	public TSheet() {
	}

	/** minimal constructor */
	public TSheet(Integer isdelete) {
		this.isdelete = isdelete;
	}

	/** full constructor */
	public TSheet(Integer courseid, Integer stuinfoid, Double fraction,
			String evaluate, Integer isdelete, String remakes) {
		this.courseid = courseid;
		this.stuinfoid = stuinfoid;
		this.fraction = fraction;
		this.evaluate = evaluate;
		this.isdelete = isdelete;
		this.remakes = remakes;
	}

	// Property accessors

	public Integer getSheetid() {
		return this.sheetid;
	}

	public void setSheetid(Integer sheetid) {
		this.sheetid = sheetid;
	}

	public Integer getCourseid() {
		return this.courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public Integer getStuinfoid() {
		return this.stuinfoid;
	}

	public void setStuinfoid(Integer stuinfoid) {
		this.stuinfoid = stuinfoid;
	}

	public Double getFraction() {
		return this.fraction;
	}

	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}

	public String getEvaluate() {
		return this.evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public String getRemakes() {
		return this.remakes;
	}

	public void setRemakes(String remakes) {
		this.remakes = remakes;
	}

}