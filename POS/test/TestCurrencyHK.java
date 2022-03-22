import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCurrencyHK {

	private HKCurrency hkc;
	
    @BeforeEach
    public void setUp() throws Exception {
    	hkc = new HKCurrency();
    }

    @AfterEach
    public void tearDown() throws Exception {
    	hkc = null;
    }
    
	@Test
	void TestHKShow() {
		assertTrue(hkc.show().equals("HK$"));
	}

}
