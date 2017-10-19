package maintain_fees.model;

public class SetIdMonthWidth {
	private String u_id;
	private String p_month;
	private int width;
	
	public SetIdMonthWidth(){};
	public SetIdMonthWidth(String u_id, String p_month, int width) {
		super();
		this.u_id = u_id;
		this.p_month = p_month;
		this.width = width;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getP_month() {
		return p_month;
	}
	public void setP_month(String p_month) {
		this.p_month = p_month;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	
	
}
