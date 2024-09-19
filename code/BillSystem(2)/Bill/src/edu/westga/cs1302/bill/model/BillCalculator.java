package edu.westga.cs1302.bill.model;

public class BillCalculator {

	/** Calculates the subtotal for an array of bill items.
	 * 
	 * @precondition items != null
	 * @postcondition none
	 * 
	 * @return subtotal The subtotal of all the items
	 * 
	 */
	public static double getSubtotal(BillItem[] items) {
		if (items == null) {
			throw new IllegalArgumentException("Must have Bill Items");
		}
		double subtotal = 0;
		for (int index = 0; index < items.length; index++) {
			if (items[index] != null) {
				subtotal = subtotal + items[index].getAmount();
			} else {
				break;
			}
		}
		return subtotal;
	}
}