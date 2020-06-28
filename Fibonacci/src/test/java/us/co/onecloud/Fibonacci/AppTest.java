package us.co.onecloud.Fibonacci;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest
{
	private App app = new App();
	
    /**
     * Rigourous Test :-)
     */
	@Test
    public void testFibonacciZeroTerm()
    {
		int result = app.fibonacci(0);
        Assert.assertEquals(0, result);
    }
	
	@Test(expected = java.lang.AssertionError.class)
    public void testFibonacciLessThanZero()
    {
		app.fibonacci(-1);
        //Assert.assertArrayEquals( standard, result );
    }
	
	@Test
    public void testFibonacci1()
    {
		int result = app.fibonacci(1);
        Assert.assertEquals(1, result);;
    }
	
	@Test
    public void testFibonacci5()
    {
		int result = app.fibonacci(5);
        Assert.assertEquals(5, result);;
    }
	
	@Test
    public void testFibonacci10()
    {
		int result = app.fibonacci(10);
        Assert.assertEquals(55, result);;
    }
}
