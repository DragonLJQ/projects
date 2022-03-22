import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCurrencyUS {

	private USCurrency usc;
	
    @BeforeEach
    public void setUp() throws Exception {
    	usc = new USCurrency();
    }

    @AfterEach
    public void tearDown() throws Exception {
    	usc = null;
    }
    
	@Test
	void TestHKShow() {
		assertTrue(usc.show().equals("US$"));
	}


}
