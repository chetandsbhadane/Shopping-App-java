import java.util.Date;
import java.util.Scanner;

public class ShopInfo {

	Scanner sc = new Scanner(System.in);
	
	public Customer create() {
		
		System.out.println("Enter customer Id ");
		int custId = sc.nextInt();
		
		System.out.println("Enter Customer Name ");
		String custName = sc.next();
		
		System.out.println("Enter Mobile Number ");
		String mobNo = sc.next();
		
		System.out.println("------Enter Address Details-------");
		System.out.println("Enter Customer City ");
		String city = sc.next();
		
		System.out.println("Enter customer State ");
		String state = sc.next();
		
		System.out.println("Enter customer pincode ");
		int pincode = sc.nextInt();
		
		Address addr = new Address(city, state, pincode);
		
		System.out.println("How many products do you want ");
		int n = sc.nextInt();
		Product prodArr[] = new Product[n];
		for(int i=0;i<prodArr.length;i++) {
			System.out.println("Enter product " + (i+1) + " Details...");
			System.out.println("Enter product ID, product Name, Price, Qty..");
			prodArr[i] = new Product(sc.nextInt(), sc.next(), sc.nextDouble(), sc.nextInt());
		}
		
		Customer cust = new Customer(custId, custName, mobNo, addr, prodArr);
		return cust;
	}
	
	public void calculateBill(Customer cust) {
		double total=0,cgst,sgst;
		double finaltotal,finaltotal2,dAmt;
		String descr;
		
		Product parr[] = cust.getProd();
		for(int i=0;i<parr.length;i++) {
			total = total + parr[i].getProdPrice() * parr[i].getProdQty();
		}
		cgst = total*0.06;
		sgst = total*0.06;
		finaltotal = total+cgst+sgst;
		
//		Bill bill = new Bill(new Date(), 123, total, cgst, sgst, finaltotal,new discount, lastPrice);
		Bill bill = new Bill(new Date(), 123, total, cgst, sgst, finaltotal);
		cust.setBill(bill);
		
		if(finaltotal<5000) {
			dAmt = 0;
			descr = "No discount";
		}
		else if((finaltotal>=5000) && (finaltotal<10000)) {
			dAmt = finaltotal*0.05;
			descr = "5% discount";
		}
		else {
			dAmt = finaltotal*0.1;
			descr = "10% discount";
		}
		finaltotal2 = finaltotal-dAmt;
		Discount dObj2 = new Discount(99, dAmt, descr);
		bill.setdObj(dObj2);

	}
	
	public void display(Customer cust) {
		
		System.out.println("Cust Id : " + cust.getCustId());
		System.out.println("Cust name : " + cust.getCustName());
		System.out.println("Cust mob : " + cust.getMobNo());
		System.out.println("-----------Address--------");
		Address add = cust.getAddr();
		System.out.println("Cust city : " + add.getCity());
		System.out.println("Cust state : " + add.getState());
		System.out.println("Cust pincode : " + add.getPincode());
		System.out.println("-----------Product data----------");
		Product parr[] = cust.getProd();
		for(int i=0;i<parr.length;i++) {
			System.out.println(parr[i].getProdId()+"\t"+parr[i].getProdName()+"\t"+parr[i].getProdPrice()+"\t"+parr[i].getProdQty());	
		}
		System.out.println("-------------Bill details-----------");
		System.out.println("Date : "+ cust.getBill().getDate() + "\tInvoice no : \t"+"" + cust.getBill().getBillNo());
		System.out.println("--------------------------------------------------------------");
		System.out.println("Total : " + cust.getBill().getTotal());
		System.out.println("CGST : " + cust.getBill().getCgst());
		System.out.println("SGST : " + cust.getBill().getSgst());
		System.out.println("Final Total : " + cust.getBill().getFinaltotal());
		System.out.println("------------------------ Discount --------------------------");
//		System.out.println("If final amt is > 1000 you'll get 10% discount");
		System.out.println("Discount No : " + cust.getBill().getdObj().getdId());
		System.out.println("Disocunt amount : " + cust.getBill().getdObj().getdAmt());
		System.out.println("Discount % : " + cust.getBill().getdObj().getDescr());
		System.out.println("Final Bill : " +(cust.getBill().getFinaltotal() - cust.getBill().getdObj().getdAmt()));
		
		System.out.println("--------------- ThankYou visit again --------------------");
		
	}
}
