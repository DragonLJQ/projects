import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class TestReadConsoleInput {

	@Test
	public void test() {
		//NOTE: This test file does not cover any project code. It is only used to demonstrate the method to simulate the console input
		InputStream oldStdIn = System.in;
		String inputStr = "f f f f f";
		ByteArrayInputStream in = new ByteArrayInputStream(inputStr.getBytes());
		System.setIn(in);

		// test program based on the inputStr string here 
		TestClassForNestedMethodsUsingScanner testClassObj = new ExtendedTestClassForNestedMethodsUsingScanner();
		String returnedString = testClassObj.f();
		System.out.println(returnedString);
		assertTrue(returnedString.equals("f, g, f"));

		// reset System.in after testing
		System.setIn(oldStdIn);
	}

}

class TestClassForNestedMethodsUsingScanner {
	public String f() {
		Scanner scanner = new Scanner(System.in);
		String firstWord = scanner.next();
		String returnOfG = g();
		String secondWord = scanner.next();
		return firstWord + ", " + returnOfG + ", " + secondWord;
	}
	
	public String g() {
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}
}

class ExtendedTestClassForNestedMethodsUsingScanner extends TestClassForNestedMethodsUsingScanner {
	@Override
	public String g() {
		String inputStr = "g g g g g";
		ByteArrayInputStream in = new ByteArrayInputStream(inputStr.getBytes());
		System.setIn(in);
		String returnedStr = super.g();
		return returnedStr;
	}
}