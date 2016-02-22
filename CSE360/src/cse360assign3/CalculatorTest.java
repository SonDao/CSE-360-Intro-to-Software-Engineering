package cse360assign3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testCalculator() {
		// testing the constructor does not return a null
		Calculator calc = new Calculator();
		assertNotNull(calc);
		// testing the initial local variable
		assertEquals(0, calc.getTotal());
		// testing the strHistory
		String expected = "0";
		assertEquals(expected, calc.getHistory());
	}
	
	@Test
	public void testGetTotal() {
		Calculator calc = new Calculator();
		// testing if the method getTotal returns a value
		assertNotNull(calc.getTotal());
		// testing if getTotal returns 0 before any mathematical operations
		assertEquals(calc.getTotal(), 0);
	}

	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		// testing if add can add positive number
		calc.add(5);
		assertEquals(calc.getTotal(), 5);
		// testing if add can add negative number
		calc.add(-5);
		assertEquals(calc.getTotal(), 0);
		// testing if it is possible to add 0
		calc.add(0);
		assertEquals(calc.getTotal(), 0);
		// test if the operations are recorded in the strHistory
		String expected = "0 + 5 + -5 + 0";
		assertEquals(expected, calc.getHistory());
	}

	@Test
	public void testSubtract() {
		Calculator calc = new Calculator();
		// testing if add can subtract positive number
		calc.subtract(5);
		assertEquals(calc.getTotal(), -5);
		// testing if add can subtract negative number
		calc.subtract(-5);
		assertEquals(calc.getTotal(), 0);
		// testing if it is possible to subtract 0
		calc.subtract(0);
		assertEquals(calc.getTotal(), 0);
		// test if the operations are recorded in the strHistory
		String expected = "0 - 5 - -5 - 0";
		assertEquals(expected, calc.getHistory());
	}

	@Test
	public void testMultiply() {
		Calculator calc = new Calculator();
		// testing 0 multiplied by a positive number
		calc.multiply(5);
		assertEquals(calc.getTotal(), 0);
		// testing 0 multiplied by a negative number
		calc.multiply(-5);
		assertEquals(calc.getTotal(), 0);
		// testing 0 * 0
		calc.multiply(0);
		assertEquals(calc.getTotal(), 0);
		//testing positive number * positive number
		calc.add(10);
		calc.multiply(5);
		assertEquals(calc.getTotal(), 50);
		// testing positive number * negative number
		calc.multiply(-2);
		assertEquals(calc.getTotal(), -100);
		// test if the operations are recorded in the strHistory
		String expected = "0 * 5 * -5 * 0 + 10 * 5 * -2";
		assertEquals(expected, calc.getHistory());
	}

	@Test
	public void testDivide() {
		Calculator calc = new Calculator();
		// testing 0 divided by a positive number
		calc.divide(5);
		assertEquals(calc.getTotal(), 0);
		// testing 0 divided by a negative number
		calc.divide(-5);
		assertEquals(calc.getTotal(), 0);
		// testing 0 / 0
		try
		{
			calc.divide(0);
			fail("throw exception");
		}
		catch (ArithmeticException e)
		{}
		//testing positive number / positive number
		calc.add(10);
		calc.divide(5);
		assertEquals(calc.getTotal(), 2);
		// testing positive number / negative number
		calc.divide(-2);
		assertEquals(calc.getTotal(), -1);
		// test if the operations are recorded in the strHistory
		String expected = "0 / 5 / -5 / 0 + 10 / 5 / -2";
		assertEquals(expected, calc.getHistory());
	}

	@Test
	public void testGetHistory() {
		Calculator calc = new Calculator();
		// testing if GetHistory returns an empty string
		String empty = "0";
		assertEquals(calc.getHistory(), empty);
		// testing if the getHistory method can correctly show the operations 
		calc.add(10);
		calc.subtract(5);
		calc.divide(5);
		calc.multiply(20);
		String expected = "0 + 10 - 5 / 5 * 20";
		assertEquals(calc.getHistory(), expected);
	}
}
 