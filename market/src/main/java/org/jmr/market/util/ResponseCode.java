package org.jmr.market.util;


/**
 * Response codes for the market. These have a wide range, and will be added to
 * as we go
 */
public enum ResponseCode{
	RESPONSE_CODE_OK(200),
	GENERIC_ERROR(500),
	ACTOR_CREATION_FAILURE(501);


	private int value;

	//Construct it
	private ResponseCode(int value){
		this.value = value;
	}

	//Get the value
	public int getValue(){
		return this.value;
	}

}
