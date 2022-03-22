import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSalesLine {

	private SalesLine salesLine;
	private Item item1;
	private Item item2;
	private Item item3;
	private PurchaseItem pitem1;
	private PurchaseItem pitem2;
	private PurchaseItem pitem3;
	
    @BeforeEach
    public void setUp() throws Exception {
    	salesLine = new SalesLine();
    	//No discount for item
    	item1 = new Item("pencil", new Integer(3), 1.5f);
    	item2 = new Item("notebook", new Integer(5), 4.5f);
    	item3 = new Item("pen", new Integer(6), 15f);
    	
    	pitem1 = new PurchaseItem(item1, 2);
    	pitem2 = new PurchaseItem(item2, 1);
    	pitem3 = new PurchaseItem(item3, 2);
    	

    }

    @AfterEach
    public void tearDown() throws Exception {
    	salesLine = null;
    }
	
	@Test
	void TestSalesLineSumprice() {
	   	salesLine.sumPrice += pitem1.number*pitem1.item.price;
    	salesLine.sumPrice += pitem2.number*pitem2.item.price;
    	salesLine.sumPrice += pitem3.number*pitem3.item.price;
    	assertEquals(1.5*2+1*4.5+15*2,salesLine.sumPrice,0.00001);
    	//System.out.println(salesLine.sumPrice);
		
	}

}
