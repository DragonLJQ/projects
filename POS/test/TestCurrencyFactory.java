import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestCurrencyFactory {

	private CurrencyFactory currencyFactory;
	@Test
	void TestCurrencyHK() {
		//System.out.println(CurrencyFactory.createCurrency(CurrencyFactory.Country.HK).show());
		String CurrencyHK = CurrencyFactory.createCurrency(CurrencyFactory.Country.HK).show();
		assertTrue(CurrencyHK.equals("HK$"));
	}
	
	@Test
	void TestCurrencyUS() {
		//System.out.println(CurrencyFactory.createCurrency(CurrencyFactory.Country.US).show());
		String CurrencyHK = CurrencyFactory.createCurrency(CurrencyFactory.Country.US).show();
		assertTrue(CurrencyHK.equals("US$"));
	}

}
