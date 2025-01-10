package org.jmr.market.payloads;

import org.jmr.market.quote.QuoteType;
import org.jmr.market.util.ResponseType;

public class ActorCreateQuoteResponse implements ActorResponse{
	private String info = "ActorCreateQuoteResponse";
	private QuoteType createdQuote;
	private ResponseType response;

	public ActorCreateQuoteResponse(){}

	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public QuoteType getCreatedQuote(){
		return this.createdQuote;
	}

	public void setCreatedQuote(QuoteType createdQuote){
		this.createdQuote = createdQuote;
	}

	public ResponseType getResponse(){
		 return this.response;
	}

	public void setResponse(ResponseType response){
		this.response = response;
	}

	@Override
	public String toString(){
		return this.info + ": " + this.createdQuote + " " + this.response;
	}
}
