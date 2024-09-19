package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetSubtotal {

	@Test
	public void testItemsCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getSubtotal(null);
		});
	}
	
	@Test
	public void testArrayCannotBeEmpty() {
		BillItem [] testItems = new BillItem[3];
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getSubtotal(testItems);
		});
	}
	
	@Test
	public void testSubtotalIsCalculatedCorrectlyInFullArray() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		testItems[1] = new BillItem("test", 8.5);
		testItems[2] = new BillItem("test", 15.7);
		assertEquals(36.4, BillCalculator.getSubtotal(testItems));	
	}
	
	@Test
	public void testSubtotalIsCalculatedCorrectlyWithTwoItem() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		testItems[1] = new BillItem("test", 8.5);
		assertEquals(20.7, BillCalculator.getSubtotal(testItems));
	}
	
	@Test
	public void testSubtotalIsCalculatedCorrectlyWithOneItem() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		assertEquals(12.2, BillCalculator.getSubtotal(testItems));
	}
	
}
