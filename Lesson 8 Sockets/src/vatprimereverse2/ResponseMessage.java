/*
 * 11.09.2019 Original version
 */


package vatprimereverse2;


import java.io.Serializable;

public class ResponseMessage
	implements Serializable
{
	private Action action;
	
	// return value for the VAT action
	private double vat;
	
	// return value for the PRIME action
	private boolean prime;
	
	// return value for the REVERSE action
	private String txet;
	
	
	public ResponseMessage( Action action )
	{
		this.action = action;
	}
	
	
	public Action getAction()
	{
		return action;
	}
	
	
	public void setVat( double vat )
	{
		this.vat = vat;
	}
	
	
	public double getVat()
	{
		return vat;
	}
	
	
	public void setPrime( boolean prime )
	{
		this.prime = prime;
	}
	
	
	public boolean getPrime()
	{
		return prime;
	}
	
	
	public void setTxet( String txet )
	{
		this.txet = txet;
	}
	
	
	public String getTxet()
	{
		return txet;
	}
}
