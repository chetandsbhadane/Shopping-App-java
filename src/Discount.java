
public class Discount {
	private int dId;
	private double dAmt;
	private String descr;
	public Discount(int dId, double dAmt, String descr) {
		super();
		this.dId = dId;
		this.dAmt = dAmt;
		this.descr = descr;
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public double getdAmt() {
		return dAmt;
	}
	public void setdAmt(double dAmt) {
		this.dAmt = dAmt;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
	
	
}
