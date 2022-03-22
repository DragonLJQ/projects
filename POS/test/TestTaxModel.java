import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTaxModel {
	private TMNoTax noTax;
	private TMVAT vaTax;
	private float oriPrice; 
	
    @BeforeEach
    public void setUp() throws Exception {
    	noTax = new TMNoTax();
    	vaTax = new TMVAT();
    	oriPrice = 1000;
    }

    @AfterEach
    public void tearDown() throws Exception {
    	noTax = null;
    	vaTax = null;
    }

	@Test
	void TestTMNoTax() {
		
		//noTax.afterTaxPrice(oriPrice);
		assertEquals(1000, noTax.afterTaxPrice(oriPrice), 0.00001);
	}
	
	@Test
	void TestTMVAT() {
		//vaTax.afterTaxPrice(oriPrice*1.1f);
		assertEquals(1000*1.1f, vaTax.afterTaxPrice(oriPrice*1.1f), 0.00001);
	}

}
