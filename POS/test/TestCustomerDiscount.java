import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCustomerDiscount {
	private CustomerDiscount cusDiscount;

	
	@BeforeEach
	public void setUp() throws Exception {
		cusDiscount = new CustomerDiscount(0.9f);	
	
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		cusDiscount = null;
	}
	
	@Test
	public void TestCusDiscount() {
		assertEquals(cusDiscount.discount(), 0.9f, 0.0001);
		//System.out.println(cusDiscount.discountMessage());
	}

	@Test
	public void TestCusDisMsg() {
		String cusDisMsg = "\tMembership Discount: " + cusDiscount.discount*100 + "%" + "\n";
		assertTrue(cusDisMsg.equals(cusDiscount.discountMessage()));
	}
}

