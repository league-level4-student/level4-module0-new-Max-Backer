package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

	// 1. Encapsulate all the members.

	// 2. Implement the setter restrictions described above each member variable.

	// 3. Pass all the JUnit tests.

	/* 
	 * All negative arguments should set itemsReceived to 0.
	 */

	private int itemsReceived;
	
	public void setItemsReceived(int num) {
		if(num < 0) {
			itemsReceived = 0;
		} else {
			itemsReceived = num;
		}
	}
	
	public int getItemsReceived() {
		 return itemsReceived;
	}

	/*
	 * degreesTurned must be locked between 0.0 and 360.0 inclusive.
	 * 
	 * All parameters outside this range should set degreesTurned to the nearest
	 * bound.
	 */

	private double degreesTurned;
	
	public void setDegreesTurned(double num) {
		if(num < 0.0) {
			degreesTurned = 0.0;
		} else if(num > 360.0) {
			degreesTurned = 360.0;
		} else {
			degreesTurned = num;
		}
	}
	
	public double getDegreesTurned() {
		return degreesTurned;
	}

	/*
	 * nomenclature must not contain an empty String.
	 * 
	 * An empty String parameter should set nomenclature to a String with a single
	 * space.
	 */

	private String nomenclature;
	public void setNomenclature(String str) {
		if(str.isEmpty()) {
			nomenclature = " ";
		} else {
			nomenclature = str;
		}
	}
	
	public String getNomenclature() {
		return nomenclature;
	}

	/*
	 * memberObj must not be a String.
	 * 
	 * A String parameter should set memberObj to a new Object();
	 * 
	 * Hint: Use the instanceof operator.
	 * 
	 * Example:
	 * 
	 * Robot rob = new Robot();
	 * 
	 * System.out.println(rob instanceof Robot); // prints true
	 * 
	 * System.out.println(rob instanceof Random); //prints false
	 */

	private Object memberObj;
	
	public void setMemberObj(Object obj) {
		if(obj instanceof String) {
			memberObj = new Object();
		} else {
			memberObj = obj;
		}
	}
	
	public Object getMemberObj() {
		return memberObj;
	}

}
