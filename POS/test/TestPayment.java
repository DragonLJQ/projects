import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestPayment {
	
	private Payment payment = new Payment();
	
	private CustomerDiscount cusDis = new CustomerDiscount(0.15f);
	
	private EventDiscount evenDis =  new EventDiscount(0.05f);
	
	private ProductDiscount proDisx = new ProductDiscount(0.2f);
	
	@Test
	void TestAddDiscount1() {
		payment.addDiscount(cusDis);

		assertEquals(0.85f, payment.totalDiscount.discount(),0.00001);
	}
	
	@Test
	void TestAddDiscount2() {
		
		payment.addDiscount(cusDis);
		
		payment.addDiscount(evenDis);
		
		assertEquals(0.85f*0.95f, payment.totalDiscount.discount(),0.00001);
	}
	
	@Test
	void TestAddDiscount3() {
		payment.addDiscount(cusDis);
		
		payment.addDiscount(evenDis);
		
		payment.addDiscount(proDisx);

		assertEquals(0.85f*0.95f*0.8f, payment.totalDiscount.discount(),0.00001);
		//System.out.println(payment.showDiscount());
	}
	
	@Test
	void TestAfterDiscount() {
		double sum = 1350.9;
		assertEquals(1350.9*payment.totalDiscount.discount(), payment.afterDiscount(sum),0.00001);
	}

	@Test
	void TestShowDiscount() {
		String discountMsg = "";
		payment.addDiscount(cusDis);
		discountMsg += cusDis.discountMessage();
		
		payment.addDiscount(evenDis);
		discountMsg += evenDis.discountMessage();
		
		//payment.addDiscount(proDisx);
		//No productDiscount message show
//		System.out.println(discountMsg);
//		System.out.println(payment.showDiscount());
		assertTrue(payment.showDiscount().contains(discountMsg));
	}
}
