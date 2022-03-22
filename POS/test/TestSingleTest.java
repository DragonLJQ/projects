import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.security.AccessControlException;
import java.security.Permission;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestSingleTest {

	private POS pos;
	
	@Test
	public void TestInitUsername(){
		
		pos = pos.getInst();
		pos.init();
		pos.userName = "chunlin";
		pos.password = "chunlin";
		Assert.assertTrue(pos.userPasswdMap.containsKey(pos.userName));
		
	}
	
	@Test
	public void TestInitPassword(){
		
		pos = pos.getInst();
		pos.init();
		pos.userName = "chunlin";
		pos.password = "chunlin";
		Assert.assertTrue(pos.userPasswdMap.get(pos.userName).equals(pos.password));
		
	}
	
	@Test
	public void TestInitCurrencyLegal() {
		pos = pos.getInst();
		pos.init();
		//System.out.println(pos.country);
		//Assert.assertTrue(pos.setCurrency(pos.country));
		
		//The fault get
		Assert.assertFalse(pos.setCurrency(pos.country));
		
	}
	
	@Test
	public void TestInitCurrencyHK() {
		pos = pos.getInst();
		pos.userPasswordFile = "userPasswordFile.txt";
		pos.init();
		String currency = pos.currency.show();
		Assert.assertTrue(currency.equals("HK$"));
		
	}
	
	@Test
	public void TestInitCurrencyUS() {
		pos = pos.getInst();
		pos.userPasswordFile = "userPasswordFile2.txt";
		pos.init();
		String currency = pos.currency.show();
		Assert.assertTrue(currency.equals("US$"));
		
	}
	
	@Test
	public void TestInitTaxModelNoTax() {
		pos = pos.getInst();
		pos.userPasswordFile = "userPasswordFile.txt";
		pos.init();
		String taxModel = pos.taxModel.toString();
		//System.out.println(taxModel);
		//Assert.assertTrue(taxModel.contains("TMNoTax"));	
		Assert.assertEquals(pos.taxModel.getClass(), TMNoTax.class);
	}
	
	@Test
	public void TestInitTaxModelVAT() {
		pos = pos.getInst();
		pos.userPasswordFile = "userPasswordFile2.txt";
		pos.init();
		String taxModel = pos.taxModel.toString();
		//System.out.println(taxModel);
		//Assert.assertTrue(taxModel.contains("TMVAT"));	
		Assert.assertEquals(pos.taxModel.getClass(), TMVAT.class);
	}
	
	@Test
	public void TestInitEventDiscount() {
		pos = pos.getInst();
		pos.userPasswordFile = "userPasswordFile.txt";
		pos.init();
		Assert.assertEquals(pos.eventDiscount.discount(), 0.05f,0.00001);
	}
	
	@Test
	public void TestInitCustomerDiscount() {
		pos = pos.getInst();
		pos.userPasswordFile = "userPasswordFile.txt";
		pos.init();
		Assert.assertEquals(pos.customerDiscount.discount(), 0.1f,0.00001);
	}
	
	@Test
	public void TestRound1() {
		//Round half up, less than half
		pos = pos.getInst();
		Assert.assertEquals(pos.round(1.43, 1, BigDecimal.ROUND_HALF_UP), 1.4,0.00001);
	}
	
	@Test
	public void TestRound2() {
		//Round half up, more than half
		pos = pos.getInst();
		Assert.assertEquals(pos.round(1.489, 2, BigDecimal.ROUND_HALF_UP), 1.49,0.00001);
	}

	@Test
	public void TestInt2StrLen1() {
		//problem:No zero length
		pos = pos.getInst();
		//System.out.println(pos.int2Str(8));
		Assert.assertTrue(pos.int2Str(8).equals("08"));
	}
	
	@Test
	public void TestInt2StrLen2() {
		//problem:No zero length
		pos = pos.getInst();
		//System.out.println(pos.int2Str(15));
		Assert.assertTrue(pos.int2Str(15).equals("15"));
	}
	
	@Test
	public void TestLoadBatchFile() {
		pos = pos.getInst();
		pos.userPasswordFile = "userPasswordFile.txt";
		pos.batchFile = "TestLoadBatchFile.txt";
		pos.init();
		pos.loadBatchFile();
		String line = null;
		try {
			line = pos.baReader.readLine();
			if(line!=null) {
				Assert.assertTrue(line.equals("zhulin"));
			}
				
		}catch(IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
	
	@Test
	public void TestGetLine() {
		pos = pos.getInst();
		pos.userPasswordFile = "userPasswordFile.txt";
		pos.batchFile = "TestLoadBatchFile.txt";
		pos.init();
		pos.loadBatchFile();
		String line = pos.getLine();
		Assert.assertTrue(line.equals("zhulin"));
	}
	
	@Test
	public void TestGetNum() {
		pos = pos.getInst();
		String sMode = "19";
		Assert.assertEquals(19, pos.getNum(sMode));
	}
	
	@Test
	public void TestGetFloat() {
		pos = pos.getInst();
		String sMode = "203.52";
		Assert.assertEquals(203.52, pos.getFloat(sMode),0.00001);
	}
	
	@Test
	public void TestMain() {
		String[] args = {"TestLoadBatchFile.txt"};
		String inputStr = "y";
		ByteArrayInputStream in = new ByteArrayInputStream(inputStr.getBytes());
		System.setIn(in);
		POS.main(args);
	}

}
