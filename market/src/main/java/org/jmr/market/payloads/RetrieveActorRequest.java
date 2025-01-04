package org.jmr.market.payloads;

import org.jmr.market.util.ActorIdType;

public class RetrieveActorRequest{
	private String info =  "RetrieveActorRequest";
	//The actor ID that we want
	private long actorId; 

	public RetrieveActorRequest(){}

	public void setInfo(String info){
		this.info = info;
	}

	public String getInfo(){
		return this.info;
	}

	public void setActorId(long actorId){
		this.actorId = actorId;
	}

	public long getActorId(){
		return this.actorId;
	}

	@Override
	public String toString(){
		return this.info + ": " + this.actorId;
	}
}
