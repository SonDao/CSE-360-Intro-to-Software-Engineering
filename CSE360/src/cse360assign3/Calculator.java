package cse360assign3;
/**
 * Class that performs mathematical operations and shows the operations in 
 * format string
 * @author Son Dao
 *
 */
public class Calculator {
	
	/**
	 * local variable
	 */
	private int total;
	private String strHistory;
	
	/**
	 * set the local variable total to 0
	 */
	public Calculator () {
		total = 0;  // not needed - included for clarity
		strHistory = "0";
	}
	
	/**
	 * getTotal - returns the result of mathematical operations
	 * @return the result of the calculations
	 */
	public int getTotal () {
		return total;
	}
	
	/**
	 * add - adds the parameter integer to the local variable
	 * @param value to be added to the local variable
	 */
	public void add (int value) {
		strHistory += " ";
		strHistory += "+";
		strHistory += " ";
		strHistory += value;
		total = total + value;
	}
	
	/**
	 * subtract - subtracts the parameter integer from the local variable
	 * @param value to be subtracted from the local variable
	 */
	public void subtract (int value) {
		strHistory += " ";
		strHistory += "-";
		strHistory += " ";
		strHistory += value;
		total = total - value;
	}
	/**
	 * Multiply the total by the parameter integer
	 * @param value to be multiplied to the local variable
	 */
	public void multiply (int value) {
		strHistory += " ";
		strHistory += "*";
		strHistory += " ";
		strHistory += value;
		total = total * value;
	}
	
	/**
	 * Divide the total by the parameter integer
	 * @param value to be divided from the local variable
	 */
	public void divide (int value) {
			strHistory += " ";
			strHistory += "/";
			strHistory += " ";
			strHistory += value;
			total = total/value;
	}
	
	/**
	 * getHistory - creates a String that show mathematical operation performed 
	 * on the local variable
	 * @return string of mathematical operation
	 */
	public String getHistory () {
		return strHistory;
		}
}