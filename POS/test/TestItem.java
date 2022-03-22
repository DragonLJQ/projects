import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestItem {
	private Item item = new Item("pencil",new Integer(5),2.50f);
	private CustomerDiscount cusDis = new CustomerDiscount(0.85f);
	

	@Test
	void TestSetDiscount() {
		item.setDiscount(cusDis);
		Assert.assertEquals(0.85f, item.discount.discount(), 0.0001);
//		Assert.assertTrue(0.85f == item1.discount.discount());
		
	}
	
	@Test
	void TestItemName() {
		Assert.assertTrue(item.itemName.equals("pencil"));
	}
	
	@Test
	void TestItemNumber() {
		Assert.assertEquals(0, item.number.compareTo(new Integer(5)));
		//Assert.assertTrue(item1.number.intValue()==5);
	}
	
	@Test
	void TestItemPrice() {
		Assert.assertEquals(2.50f, item.price, 0.0001);
	}


}
