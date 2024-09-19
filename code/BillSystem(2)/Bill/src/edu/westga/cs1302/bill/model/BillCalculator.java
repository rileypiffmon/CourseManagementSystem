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
	 * @precondition items != null && array cannot be null
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
	 * @precondition items != null && array cannot be empty
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
	
	/** Calculates the total, including tax and tip for an array of BillItems
	 * 
	 * @precondition items != null && array cannot be empty
	 * @postcondition none
	 * 
	 * @param items The array of Bill Items that will be calculated
	 * @return the total for every item in the bill together, including tax and tip
	 */
	public static double getTotal(BillItem[] items) {
		BillItem[] allItems = items;
		if (allItems == null) {
			throw new IllegalArgumentException("Must have Bill Items");
		}
		if (allItems[0] == null) {
			throw new IllegalArgumentException("Array is empty");
		}
		double subtotal = BillCalculator.getSubtotal(allItems);
		double tax = BillCalculator.getTax(allItems);
		double tip = BillCalculator.getTip(allItems);
		return subtotal + tax + tip;
	}
}