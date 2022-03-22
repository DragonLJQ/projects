

public class Payment {
	public CompositeDiscount totalDiscount;
	
	public Payment() {
		totalDiscount = new CompositeDiscount();
	}
	public void addDiscount(Discount _discount) {
		totalDiscount.add(_discount);
	}

	public double afterDiscount(double sum) {
		return sum*totalDiscount.discount();
	}
	
	public String showDiscount() {
		return totalDiscount.discountMessage();
	}
}
