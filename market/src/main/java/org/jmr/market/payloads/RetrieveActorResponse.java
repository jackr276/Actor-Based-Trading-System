package org.jmr.market.payloads;

import org.jmr.market.util.ActorType;
import org.jmr.market.util.ResponseType;

public class RetrieveActorResponse{
	private String info = "RetrieveActorResponse";
	//The actor that we actually got
	private ActorType actor;
	//The response
	private ResponseType response;

	//JSON
	public RetrieveActorResponse(){}

	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public void setActor(ActorType actor){
		this.actor = actor;
	}

	public ActorType getActor(){
		return this.actor;
	}

	public ResponseType getResponse(){
		return this.response;
	}

	public void setResponse(ResponseType response){
		this.response = response;
	}

	@Override
	public String toString(){
		return this.info + ": " + this.actor.toString();
	}
}
