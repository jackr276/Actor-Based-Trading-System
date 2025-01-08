package org.jmr.market.payloads;

import org.jmr.market.util.ResponseType;

public class ActorCreateQuoteResponse implements ActorResponse{
	private String info = "ActorCreateQuoteResponse";
	private ResponseType response;

	public ActorCreateQuoteResponse(){}

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
