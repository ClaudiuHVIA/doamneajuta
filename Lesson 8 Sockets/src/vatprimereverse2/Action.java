/*
 * 11.09.2019 Original version
 */


package vatprimereverse2;


import java.io.Serializable;

public enum Action
	implements Serializable
{
	VAT_REQUEST,
	VAT_RESPONSE,
	
	PRIME_REQUEST,
	PRIME_RESPONSE,
	
	REVERSE_REQUEST,
	REVERSE_RESPONSE,
}
