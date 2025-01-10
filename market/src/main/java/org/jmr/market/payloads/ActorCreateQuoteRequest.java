package org.jmr.market.payloads;

import java.time.Instant;

import org.jmr.market.util.SideType;

/**
 * Actors will send this request to the market user agent, and the market user
 * agent will handle the rest
 */
public class ActorCreateQuoteRequest{
	private String info = "ActorCreateQuoteRequest";
	//The instrument that we want to use
	private long instrumentId;
	//What side quote is it
	SideType side;
	//Is this a private quote
	private boolean privateQuote;
	//Offer price. Remember, all offer prices are divided by 10000
	private long offerPrice;
	//The expiration time
	private Instant expirationTime;

	//JSON
	public ActorCreateQuoteRequest(){}
	
	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public long getInstrumentId(){
		return this.instrumentId;
	}

	public void setInstrumentId(long instrumentId){
		this.instrumentId = instrumentId;
	}

	public SideType getSide(){
		return this.side;
	}

	public void setSide(SideType side){
		this.side = side;
	}

	public boolean getPrivateQuote(){
		return this.privateQuote;
	}
	
	public void setPrivateQuote(boolean privateQuote){
		this.privateQuote = privateQuote;
	}

	public long getOfferPrice(){
		return this.offerPrice;
	}

	public void setOfferPrice(long offerPrice){
		this.offerPrice = offerPrice;
	}

	public Instant getExpirationTime(){
		return this.expirationTime;
	}

	public void setExpirationTime(Instant expirationTime){
		this.expirationTime = expirationTime;
	}

	@Override
	public String toString(){
		return this.info + " " + this.instrumentId + " " + this.side + " " + this.expirationTime;
	}
}
