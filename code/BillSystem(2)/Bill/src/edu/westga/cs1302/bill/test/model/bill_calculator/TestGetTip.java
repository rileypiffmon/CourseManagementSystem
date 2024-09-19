package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetTip {

	@Test
	public void testArrayCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getTip(null);
		});
	}
	
	@Test
	public void testArrayCannotBeEmpty() {
		BillItem[] testItems= new BillItem[3];
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getTip(testItems);
		});
	}
	
	@Test
	public void testTipIsCalculatedCorrectlyInFullArray() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		testItems[1] = new BillItem("test", 8.5);
		testItems[2] = new BillItem("test", 15.7);
		double tip = BillCalculator.getTip(testItems);
		assertEquals(7.28, tip);
	}
	
	@Test
	public void testTipIsCalculatedCorrectlyWithTwoItem() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		testItems[1] = new BillItem("test", 8.5);
		double tip = BillCalculator.getTip(testItems);
		assertEquals(4.14, tip);
	}
	
	@Test
	public void testTipIsCalculatedCorrectlyWithOneItem() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		double tip = BillCalculator.getTip(testItems);
		assertEquals(2.44, tip);
	}

}
