package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetTax {

	@Test
	public void testArrayCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getTax(null);
		});
	}
	
	@Test
	public void testArrayCannotBeEmpty() {
		BillItem[] testItems= new BillItem[3];
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getTax(testItems);
		});
	}
	
	@Test
	public void testSubtotalIsCalculatedCorrectlyInFullArray() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		testItems[1] = new BillItem("test", 8.5);
		testItems[2] = new BillItem("test", 15.7);
		double tax = BillCalculator.getTax(testItems);
		assertEquals(3.64, tax);
	}
	
	@Test
	public void testSubtotalIsCalculatedCorrectlyWithTwoItem() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		testItems[1] = new BillItem("test", 8.5);
		double tax = BillCalculator.getTax(testItems);
		assertEquals(2.07, tax);
	}
	
	@Test
	public void testSubtotalIsCalculatedCorrectlyWithOneItem() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		double tax = BillCalculator.getTax(testItems);
		assertEquals(1.22, tax);
	}

}
