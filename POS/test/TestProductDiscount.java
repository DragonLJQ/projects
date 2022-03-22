import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestProductDiscount {
	private ProductDiscount proDis;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		proDis = new ProductDiscount(0.2f);	
	
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		proDis = null;
	}
	

	@Test
	public void TestProDiscount() {
		assertEquals(0.2f, proDis.discount(), 0.0001);
	}

	@Test
	public void TestProDisMsg() {
		String proDisMsg = "\tProduct Discount: " + proDis.discount*100 + "%" + "\n";
		//assertTrue(proDisMsg.equals(proDis.discountMessage()));
		assertTrue(proDisMsg.contains(proDis.discountMessage()));
	}

}
