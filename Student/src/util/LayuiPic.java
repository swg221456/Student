package util;

public class LayuiPic {
	private String src;  
    private String title;
    private int photoid;
	public LayuiPic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LayuiPic(String src, String title, int photoid) {
		super();
		this.src = src;
		this.title = title;
		this.photoid = photoid;
	}

	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPhotoid() {
		return photoid;
	}
	public void setPhotoid(int photoid) {
		this.photoid = photoid;
	} 
    
    
}
