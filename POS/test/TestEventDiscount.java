import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEventDiscount {
	private EventDiscount eventDiscount;

	
	@BeforeEach
	public void setUp() throws Exception {
		eventDiscount = new EventDiscount(0.05f);	
	
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		eventDiscount = null;
	}
	
	@Test
	public void TestEvtDiscount() {
		assertEquals(eventDiscount.discount(), 0.05f, 0.0001);
	}

	@Test
	public void TestEvtDisMsg() {
		String evtDisMsg = "\tEvent Discount: " + eventDiscount.discount*100 + "%" + "\n";
		assertTrue(evtDisMsg.equals(eventDiscount.discountMessage()));
	}

}

