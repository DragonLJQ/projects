import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

public class TestCompositeDiscount {
    private CompositeDiscount compDiscount;
    private ProductDiscount discount1;
    private ProductDiscount discount2;

    @BeforeEach
    public void setUp() throws Exception {
        compDiscount = new CompositeDiscount();
        discount1 = new ProductDiscount(0.2f);
        discount2 = new ProductDiscount(0.05f);
    }

    @AfterEach
    public void tearDown() throws Exception {
        compDiscount = null;
        discount1 = null;
        discount2 = null;
    }

    @Test
    public void testAddDiscount() {
        //initially, there is no discount   
        //assertTrue(compDiscount.discount() == 1.0f);
    	assertEquals(1.0f, compDiscount.discount(), 0.00001);
	
        //add first discount, the total discount will be 0.8
        compDiscount.add(discount1);
        //System.out.println(compDiscount.discountMessage());
        //assertTrue(compDiscount.discount() == 0.8f);
        assertEquals(0.8f, compDiscount.discount(), 0.00001);
		
        //add second discount, the total discount will be 0.8 * 0.95
        compDiscount.add(discount2);
        //assertTrue(compDiscount.discount() == 0.8f * 0.95f);
        assertEquals(0.8f*0.95f, compDiscount.discount(), 0.00001);
    }
	
    @Test
    public void testRemoveDiscount() {
        //after removing two discounts, there will be no discount
        compDiscount.remove(discount1);
        compDiscount.remove(discount2);
        assertEquals(1.0f, compDiscount.discount(), 0.00001);
        //assertTrue(compDiscount.discount() == 1.0f, "no savings after removing all discounts");
    }
}

