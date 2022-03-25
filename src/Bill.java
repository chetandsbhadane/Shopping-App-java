import java.util.Date;

public class Bill {
	private Date date;
	private int billNo;
	private double total;
	private double cgst;
	private double sgst;
	private double finaltotal;
	private Discount dObj;
	
	public Bill(Date date, int billNo, double total, double cgst, double sgst, double finaltotal) {
		super();
		this.date = date;
		this.billNo = billNo;
		this.total = total;
		this.cgst = cgst;
		this.sgst = sgst;
		this.finaltotal = finaltotal;
//		this.dObj = dObj;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getCgst() {
		return cgst;
	}
	public void setCgst(double cgst) {
		this.cgst = cgst;
	}
	public double getSgst() {
		return sgst;
	}
	public void setSgst(double sgst) {
		this.sgst = sgst;
	}
	public double getFinaltotal() {
		return finaltotal;
	}
	public void setFinaltotal(double finaltotal) {
		this.finaltotal = finaltotal;
	}
	public Discount getdObj() {
		return dObj;
	}
	public void setdObj(Discount dObj) {
		this.dObj = dObj;
	}
	
	

	
	
	
	
	
	
	
	
}
