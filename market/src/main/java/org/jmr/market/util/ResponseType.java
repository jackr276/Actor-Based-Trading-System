package org.jmr.market.util;

import java.time.Instant;

/**
 * This is the global response type for all responses
 */

public class ResponseType{
	//The response code for us
	private ResponseCode responseCode;
	//The description of it
	private String responseDescription;
	//Atomically created ID
	private SystemTransactionId transactionId;
	//When was this response created
	private Instant responseTime = Instant.now();

	//For JSON in case
	public ResponseType(){}

	//We'll probably use this more
	public ResponseType(ResponseCode responseCode, String description){
		this.responseCode = responseCode;
		this.responseDescription = description;
	}

	public ResponseCode getResponseCode(){
		return this.responseCode;
	}

	public void setResponseCode(ResponseCode responseCode){
		this.responseCode = responseCode;
	}

	public String getResponseDescription(){
		return this.responseDescription;
	}

	public void setResponseDescription(String responseDescription){
		this.responseDescription = responseDescription;
	}

	public SystemTransactionId getTransactionId(){
		return this.transactionId;
	}

	public void setTransactionId(SystemTransactionId transactionId){
		this.transactionId = transactionId;
	}

	public Instant getResponseTime(){
		return this.responseTime;
	}

	public void setResponseTime(Instant responseTime){
		this.responseTime = responseTime;
	}

	@Override
	public String toString(){
		return "Response: {" + 
				"\nResponse code: " + this.responseCode.toString() + 
				"\nResponse description: " + this.responseDescription.toString() + 
				"\nTransaction ID: " + this.transactionId.toString() +
				"\nResponse date: " + this.responseTime.toString();
	}
}

