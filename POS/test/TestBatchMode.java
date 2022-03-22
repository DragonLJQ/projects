import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.AccessControlException;
import java.security.Permission;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBatchMode {
	private POS filePos;
	private InputStream oldStdIn;
	private PrintStream oldStdOut;

	
	@Before
	public void setUp() {
		
		final SecurityManager securityManager = new SecurityManager() {
			public void checkPermission(Permission permission) {
				if (permission.getName().startsWith("exitVM")) {
					throw new AccessControlException(permission.getName());
				}
			}
		};
		System.setSecurityManager(securityManager);

		filePos = new ExtendedFilePOS();
		oldStdIn = System.in;
		oldStdOut = System.out;
		filePos.init();
		filePos.batchMode = true;
		
	}

	@After
	public void tearDown() {
		System.setIn(oldStdIn);
		System.setOut(oldStdOut);
	}
	

	

	@Test
	public void TestFailUserPasswordFile() {
		filePos.userPasswordFile = "wrongUserPsdformat.txt";
		
		try {
			filePos.init();
		} catch (RuntimeException e) {
			Assert.assertTrue(e.toString().contains("exitVM.1"));
		} finally {
			System.setSecurityManager(null);
		}

		
	}
	
	@Test
	public void TestNotExistingFile() {
		//Not existing file
		filePos.itemListFile = "ttt.txt";
		
		try {
			filePos.init();
		} catch (RuntimeException e) {
			Assert.assertTrue(e.toString().contains("exitVM.1"));
		} finally {
			System.setSecurityManager(null);
		}

		System.out.println("end");
		
	}
	
	
	@Test
	public void TestWrongItemIDFile() {
		filePos.itemListFile = "wrongItemIDformat.txt";
				
		try {
			filePos.init();
		} catch (RuntimeException e) {
			Assert.assertTrue(e.toString().contains("exitVM.1"));
		} finally {
			System.setSecurityManager(null);
		}

		System.out.println("end");
		
	}

	
	@Test 
	public void TestRegisterFileInputCorrect() {
		
		filePos.batchFile = "command.txt"; 
		filePos.loadBatchFile();
		filePos.register(); 			
		
	}
	
	@Test
	public void TestRegisterWrongBatchFile() {
		filePos.batchMode = true;
		filePos.batchFile = "xxxx.txt";
		
		try {
			filePos.loadBatchFile();
		} catch (RuntimeException e) {
			Assert.assertTrue(e.toString().contains("exitVM.1"));
		} finally {
			System.setSecurityManager(null);
		}

		System.out.println("end");

	}

	 
	@Test
	public void TestRegisterFileInputWrongUser() {
		filePos.batchMode = true;
		filePos.batchFile = "commandWrongUser.txt";
		filePos.loadBatchFile();
		try {
			filePos.register();
		} catch (RuntimeException e) {
			Assert.assertTrue(e.toString().contains("exitVM.1"));
		} finally {
			System.setSecurityManager(null);
		}

		System.out.println("end");

	}

	
	 @Test
	 public void TestRegisterFileInputWrongPwd() { 
		filePos.batchMode = true;
		filePos.batchFile = "commandWrongPwd.txt"; 
		filePos.loadBatchFile();
		try {
			filePos.register();
		} catch (RuntimeException e) {
			Assert.assertTrue(e.toString().contains("exitVM.1"));
		} finally {
			System.setSecurityManager(null);
		}

		System.out.println("end");
	 }
	 
	 @Test
	 public void TestRegisterFileInputWrongItemID() {
		 filePos.batchMode = true;
		 filePos.batchFile = "commandWrongItemID.txt";
		 filePos.loadBatchFile();
		 try {
			 filePos.register();
		 } catch (RuntimeException e) {
			 Assert.assertTrue(e.toString().contains("exitVM.1"));
		 } finally {
			 System.setSecurityManager(null);
		 }
		 
		 System.out.println("end");
		 
	 }
	 
	 
	 @Test
	 public void TestRegisterFileInputWrongItemIDNum() {
		 filePos.batchMode = true;
		 filePos.batchFile = "commandWrongItemIDNum.txt";
		 filePos.loadBatchFile();
		 try {
			 filePos.register();
		 } catch (RuntimeException e) {
			 Assert.assertTrue(e.toString().contains("exitVM.1"));
		 } finally {
			 System.setSecurityManager(null);
		 }
		 
		 System.out.println("end");
		 
	 }
	 
	 @Test
	 public void TestRegisterFileInputWrongItemIDNum2() {
		 filePos.batchMode = true;
		 filePos.batchFile = "commandWrongItemIDNum2.txt";
		 filePos.loadBatchFile();
		 try {
			 filePos.register();
		 } catch (RuntimeException e) {
			 Assert.assertTrue(e.toString().contains("exitVM.1"));
		 } finally {
			 System.setSecurityManager(null);
		 }
		 
		 System.out.println("end");
		 
	 }
	 
	 @Test
	 public void TestRegisterFileInputWrongMoney() {
		 filePos.batchMode = true;
		 filePos.batchFile = "commandWrongMoney.txt";
		 filePos.loadBatchFile();
		 try {
			 filePos.register();
		 } catch (RuntimeException e) {
			 Assert.assertTrue(e.toString().contains("exitVM.1"));
		 } finally {
			 System.setSecurityManager(null);
		 }
		 
		 System.out.println("end");
		 
	 }
	 
	 
	 @Test
	 public void TestRegisterFileInputWrongMoney2() {
		 filePos.batchMode = true;
		 filePos.batchFile = "commandWrongMoney2.txt";
		 filePos.loadBatchFile();
		 try {
			 filePos.register();
		 } catch (RuntimeException e) {
			 Assert.assertTrue(e.toString().contains("exitVM.1"));
		 } finally {
			 System.setSecurityManager(null);
		 }
		 
		 System.out.println("end");
		 
	 }
	 
	 
	 @Test
	 public void TestRegisterFileInputWrongMoney3() {
		 filePos.batchMode = true;
		 filePos.batchFile = "commandWrongMoney3.txt";
		 filePos.loadBatchFile();
		 try {
			 filePos.register();
		 } catch (RuntimeException e) {
			 Assert.assertTrue(e.toString().contains("exitVM.1"));
		 } finally {
			 System.setSecurityManager(null);
		 }
		 
		 System.out.println("end");
		 
	 }
	 
	 
	
	 
}

class ExtendedFilePOS extends POS {
	@Override
	public void saleRegister() {
		String inputStr = "y n";
		ByteArrayInputStream in = new ByteArrayInputStream(inputStr.getBytes());
		System.setIn(in);
		super.saleRegister();
	}
}