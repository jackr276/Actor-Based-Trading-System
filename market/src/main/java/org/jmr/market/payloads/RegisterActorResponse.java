package org.jmr.market.payloads;

import org.jmr.market.util.ActorIdType;

public class RegisterActorResponse{
	//This is the actor ID that newly registered individuals are given
	private ActorIdType actorId;

	//JSON
	public RegisterActorResponse(){}

	public void setActorId(ActorIdType actorId){
		this.actorId = actorId;
	}

	public ActorIdType getActorId(){
		return this.actorId;
	}

	@Override
	public String toString(){
		return "RegisterActorResponse {\n" + actorId.toString() + "}";
	}

}
