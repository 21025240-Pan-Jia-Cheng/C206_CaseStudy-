import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21022510, 1 Jun 2022 10:16:32 am
 */

public class CalculatorTest {
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		
		//Arrange
		int a = 4321;
		int b = 1234;
		
		Calculator cal = new Calculator();
		
		//Act
		int actual = cal.add(a, b); 
		
		//Assert
		int expected = 5555;
		assertEquals(expected, actual);
		}
	
	public void testSubtract() {
		//Arrange
		int a = 4321;
		int b = 1234;
			
		Calculator cal = new Calculator();
		
		//Act
		int actual = cal.subtract(a, b);
		
		//Assert
		int expected = 5555;
		assertEquals(expected, actual);
		}
	
	public void testMultiply() {
		//Arrange
		int a = 4321;
		int b = 1234;
			
		Calculator cal = new Calculator();
		
		//Act
		int actual = cal.multiply(a, b);
		
		//Assert
		int expected = 5555;
		assertEquals(expected, actual);
		}
	
	public void testDivide() {
		//Arrange
		int a = 4321;
		int b = 1234;
			
		Calculator cal = new Calculator();
		
		//Act
		int actual = cal.divide(a, b);
		
		//Assert
		int expected = 5555;
		assertEquals(expected, actual);
		}


	
}
