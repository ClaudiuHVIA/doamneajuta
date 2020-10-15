/*
 * 11.09.2019 Original version
 */


package vatprimereverse2;


import java.io.Serializable;

public class RequestMessage
	implements Serializable
{
	private Action action;

	// argument for the VAT action
	private double amount;
	
	// argument for the PRIME action
	private long n;
	
	// argument for the REVERSE action
	private String text;
	
	
	public RequestMessage( Action action )
	{
		this.action = action;
	}
	
	
	public Action getAction()
	{
		return action;
	}
	
	
	public void setAmount( double amount )
	{
		this.amount = amount;
	}
	
	
	public double getAmount()
	{
		return amount;
	}
	
	
	public void setN( long n )
	{
		this.n = n;
	}
	
	
	public long getN()
	{
		return n;
	}
	
	
	public void setText( String text )
	{
		this.text = text;
	}
	
	
	public String getText()
	{
		return text;
	}
}
