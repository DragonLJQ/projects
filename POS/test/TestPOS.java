import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestPOS {

	private POS pos;
	private InputStream oldStdIn;
	private PrintStream oldStdOut;
	
	@Before
	public void setUp() {

		pos = new ExtendedPOS();
		oldStdIn = System.in;
		oldStdOut = System.out;
	}
	
	@After
	public void tearDown() {
		System.setIn(oldStdIn);
		System.setOut(oldStdOut);
	}
	
	@Test
	public void testTest() {
		Assert.assertEquals(pos.test(), 1);
	}
	

	@Test
	public void TestRegisterConsoleHK(){
		pos.init();
		pos.batchMode = false;
		String str = "chunlinx chunlin chunlinxx chunlin";
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		System.setIn(in);

		pos.register();

		//System.out.println(pos.country);
	}
	

	@Test
	public void TestRegisterConsoleUS() {
		
		pos.userPasswordFile = "userPasswordFile2.txt";
		pos.init();
		String str = "yangjunx yangjun yangjunxx yangjun 1 2";
		ByteArrayInputStream inx = new ByteArrayInputStream(str.getBytes());
		System.setIn(inx);
		
		pos.register();
	}

	

}


class ExtendedPOS extends POS{
	@Override
	public void saleRegister() {
		
		String inputStr = "4 1 m y ID001 x ID0101 ID010 -4 ID003 100000 c -1.2 x 120.8 1 n c 0 2";
		ByteArrayInputStream in = new ByteArrayInputStream(inputStr.getBytes());
		System.setIn(in);
		super.saleRegister();
	}
	
	@Override
	public int getNum(String sMode) {
		int mode = 0;
		String newStr = sMode;
		int retrunedNum;
		try {
			mode = Integer.parseInt(sMode);
			retrunedNum = mode;
			if(mode<0) {
				newStr = String.valueOf(-retrunedNum);
				ByteArrayInputStream in = new ByteArrayInputStream(newStr.getBytes());
				System.setIn(in);
				retrunedNum = super.getNum(sMode);
			}
		}catch(NumberFormatException e) {
			String wrongNum = "0";
			ByteArrayInputStream in = new ByteArrayInputStream(wrongNum.getBytes());
			System.setIn(in);
			retrunedNum = super.getNum(sMode);
		}
				
		return retrunedNum;
		
	}
	
	
	@Override
	public float getFloat(String sMode) {
		System.out.println("sMode: "+sMode);
		float mode;
		String newStr = sMode;
		float retrunedNum;
		try {
			mode = Float.parseFloat(sMode);
			retrunedNum = mode;
			if(mode<0) {
				newStr = String.valueOf(-retrunedNum);
				System.out.println("newStr: "+newStr);
				ByteArrayInputStream in = new ByteArrayInputStream(newStr.getBytes());
				System.setIn(in);
				retrunedNum = super.getFloat(sMode);
			}
		}catch(NumberFormatException e) {
			String wrongNum = "110";
			ByteArrayInputStream in = new ByteArrayInputStream(wrongNum.getBytes());
			System.setIn(in);
			retrunedNum = super.getFloat(sMode);
		}
				
		return retrunedNum;
	}
}
