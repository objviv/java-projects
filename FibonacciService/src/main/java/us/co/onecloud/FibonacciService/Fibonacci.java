/**
 * 
 */
package us.co.onecloud.FibonacciService;

import java.io.Serializable;

/**
 * @author vkhanna
 *
 */
public class Fibonacci implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int term;
	private long value;
	
	public Fibonacci()
	{
		term = 0;
		value = 0L;
	}
	
	public Fibonacci(int term, long value)
	{
		this.term = term;
		this.value = value;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

}
