package org.jmr.market.util;


/**
 * A class for a given actor in the market. This allows us to 
 * encapsulate actor behavior in one place
 */
public class ActorType{
	//The Actor's ID
	private ActorIdType actorId;
	//The Actors IP address
	private IPv4Address actorAddress; 
	//The actor port
	private long port;
	//Is the actor subscribed to instrument tickers?
	private boolean subscribedToInstrumentTicker = false;
	//Is the actor subscribed to quote tickers?
	private boolean subscribedToQuoteTicker = false;
	//TODO other attributes may come here, this will do for now

	//JSON
	public ActorType(){}

	public void setActorId(ActorIdType actorId){
		this.actorId = actorId;
	}

	public ActorIdType getActorId(){
		return this.actorId;
	}


	public void setActorAddress(IPv4Address actorAddress){
		this.actorAddress = actorAddress;
	}

	public IPv4Address getActorAddress(){
		return this.actorAddress;
	}

	public void setPort(long port){
		this.port = port;
	}

	public long getPort(){
		return this.port;
	}

	public boolean getSubscribedToInstrumentTicker(){
		return this.subscribedToInstrumentTicker;
	}

	public void setSubscribedToInstrumentTicker(boolean subscribedToInstrumentTicker){
		this.subscribedToInstrumentTicker = subscribedToInstrumentTicker;
	}

	public boolean getSubscribedToQuoteTicker(){
		return this.subscribedToQuoteTicker;
	}

	public void setSubscribedToQuoteTicker(boolean subscribedToQuoteTicker){
		this.subscribedToQuoteTicker = subscribedToQuoteTicker;
	}

	@Override
	public String toString(){
		return "ActorType: {\n" + this.actorId.toString() + "\n" + this.actorAddress.toString() + "\n}";
	}
}
