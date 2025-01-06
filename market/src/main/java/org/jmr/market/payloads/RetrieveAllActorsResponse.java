package org.jmr.market.payloads;

import java.util.List;

import org.jmr.market.util.ActorType;
import org.jmr.market.util.ResponseType;

/**
 * The response will contain a list of actors that we have
 */
public class RetrieveAllActorsResponse{
	private String info = "RetrieveAllActorsResponse";
	private List<ActorType> actors;
	private ResponseType response;

	//JSON
	public RetrieveAllActorsResponse(){}

	public ResponseType getResponse(){
		return this.response;
	}

	public void setResponse(ResponseType response){
		this.response = response;
	}


	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public void setActors(List<ActorType> actors){
		this.actors = actors;
	}

	public List<ActorType> getActors(){
		return this.actors;
	}

	@Override
	public String toString(){
		return this.info + ": Actors: " + this.actors.toString();
	}
}
