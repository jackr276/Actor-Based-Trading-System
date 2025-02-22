package org.jmr.market.payloads;

import org.jmr.market.util.ActorType;
import org.jmr.market.util.ResponseType;

public class RegisterActorResponse implements ActorResponse{
	private String info = "RegisterActorResponse";
	//This is the actor ID that newly registered individuals are given
	private ActorType actor;
	//The response that we get
	private ResponseType response;

	//JSON
	public RegisterActorResponse(){}

	public void setActor(ActorType actor){
		this.actor = actor;
	}

	public ActorType getActor(){
		return this.actor;
	}


	public void setResponse(ResponseType response){
		this.response = response;
	}

	public ResponseType getResponse(){
		return this.response;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public String getInfo(){
		return this.info;
	}
	@Override
	public String toString(){
		return "RegisterActorResponse {\n" + actor.toString() + "}";
	}

}
