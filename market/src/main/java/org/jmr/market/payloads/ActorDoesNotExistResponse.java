package org.jmr.market.payloads;

import org.jmr.market.util.ResponseType;

/**
 * This response will be used when an actor ID that is not recognized is sent into the system
 */
public class ActorDoesNotExistResponse implements ActorResponse{
	private String info = "ActorDoesNotExistResponse";
	private ResponseType response;

	//JSON
	public ActorDoesNotExistResponse(){}

	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public ResponseType getResponse(){
		return this.response;
	}

	public void setResponse(ResponseType response){
		this.response = response;
	}

	@Override
	public String toString(){
		return this.info + ": " + this.response;
	}
}
