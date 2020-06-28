package us.co.onecloud.Fibonacci;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static Logger logger = Logger.getLogger("us.co.onecloud.Fibonacci");
	private String className = null;
	
	public App() 
	{
		className = this.getClass().getSimpleName();
	}
	
	/**
	 * Compute n'th Fibonacci term.
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacci(int n) 
	{
		StringBuilder sb = new StringBuilder(className);
		
		sb.append("; fibonacci(").append(n).append(") called");
		logger.fine(sb.toString());
		
		assert(n >= 0);
		
		int ret;
		if (0 == n)
		{
			sb = new StringBuilder(className).append("; returning 0");
			logger.fine(sb.toString());
			ret = 0;
		}
		else if (1 == n)
		{
			sb = new StringBuilder(className).append("; returning 1");
			logger.fine(sb.toString());
			ret = 1;
		}
		else 
		{	
			ret = fibonacci(n - 1) + fibonacci(n - 2);
			
			sb = new StringBuilder(className).append("; returning ").append(ret);
			logger.fine(sb.toString());
		}
		return ret;
	}
	
    public static void main( String[] args )
    {        
        int r = new App().fibonacci(10);
        System.out.println( "Hello World!" + r );
    }
}
