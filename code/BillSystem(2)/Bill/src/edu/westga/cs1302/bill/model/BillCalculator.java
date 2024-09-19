package edu.westga.cs1302.bill.model;

public class BillCalculator {

	/** Calculates the subtotal for an array of bill items.
	 * 
	 * @precondition items != null && array cannot be empty
	 * @postcondition none
	 * 
	 * @param items The array of BillItems being calculated
	 * @return subtotal The subtotal of all the items
	 * 
	 */
	public static double getSubtotal(BillItem[] items) {
		if (items == null) {
			throw new IllegalArgumentException("Must have Bill Items");
		}
		double subtotal = 0;
		for (int index = 0; index < items.length; index++) {
			if (index == 0 && items[index] == null) {
				throw new IllegalArgumentException("Array is empty");
			}
			if (items[index] != null) {
				subtotal = subtotal + items[index].getAmount();
			} else {
				break;
			}
		}
		return subtotal;
	}
	
	/** Calculates the tax for a set of BillItems
	 * 
	 * @precondition items != null
	 * @postcondition none
	 * 
	 * @param items The array of BillItems that will be used
	 * @return the tax for the subtotal of the items in the array
	 */
	public static double getTax(BillItem[] items) {
		BillItem[] taxedItems = items;
		if (taxedItems == null) {
			throw new IllegalArgumentException("Must have Bill Items");
		}
		if (taxedItems[0] == null) {
			throw new IllegalArgumentException("Array is empty");
		}
		return BillCalculator.getSubtotal(taxedItems) * 0.1;
	}
	
	/** Calculates the tip for a set of BillItems
	 * 
	 * @precondition items != null
	 * @postcondition none
	 * 
	 * @param items The array of BillItems that will be used
	 * @return the tip for the subtotal of the items in the array
	 */
	public static double getTip(BillItem[] items) {
		BillItem[] tipItems = items;
		if (tipItems == null) {
			throw new IllegalArgumentException("Must have Bill Items");
		}
		if (tipItems[0] == null) {
			throw new IllegalArgumentException("Array is empty");
		}
		return BillCalculator.getSubtotal(tipItems) * 0.2;
	}
}