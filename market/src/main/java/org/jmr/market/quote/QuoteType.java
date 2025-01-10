package org.jmr.market.quote;

import java.time.Instant;

import org.jmr.market.instrument.InstrumentIdType;
import org.jmr.market.util.ActorIdType;
import org.jmr.market.util.SideType;

public class QuoteType {
	//The quoteID
	private QuoteIdType quoteId;
	//Never populated by the user directly
	private ActorIdType actorId;
	//The instrument being purchased
	private InstrumentIdType instrumentId;
	//The offering price
	private long offerPrice;
	//The side of the quote
	private SideType side;
	//Is this a private quote?
	private boolean privateQuote;
	//Is there an expiration time?
	private Instant expirationTime = null;
	
	//JSON
	public QuoteType(){}


	public void setQuoteId(QuoteIdType quoteId){
		this.quoteId = quoteId;
	}

	public QuoteIdType getQuoteId(){
		return this.quoteId;
	}

	public void setActorId(ActorIdType actorId){
		this.actorId = actorId;
	}

	public ActorIdType getActorId(){
		return this.actorId;
	}

	public void setInstrumentId(InstrumentIdType instrumentId){
		this.instrumentId = instrumentId;
	}

	public InstrumentIdType getInstrumentId(){
		return this.instrumentId;
	}

	public void setOfferPrice(long offerPrice){
		this.offerPrice = offerPrice;
	} 

	public long getOfferPrice(){
		return this.offerPrice;
	}

	public void setSideType(SideType side){
		this.side = side;
	}

	public SideType getSide(){
		return this.side;
	}

	public void setPrivateQuote(boolean privateQuote){
		this.privateQuote = privateQuote;
	}

	public boolean getPrivateQuote(){
		return this.privateQuote; 
	}

	public void setExpirationTime(Instant expirationTime){
		this.expirationTime = expirationTime;
	}

	public Instant getExpirationTime(){
		return this.expirationTime;
	}

	@Override
	public String toString(){
		return "Quote: " + "quoteId: " + this.quoteId;
	}
}
