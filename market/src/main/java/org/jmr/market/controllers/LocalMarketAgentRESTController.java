package org.jmr.market.controllers;

import org.jmr.market.payloads.RegisterActorResponse;
import org.jmr.market.util.ActorIdType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/local_market_agent")
public class LocalMarketAgentRESTController {
	//In our system, the LMA itself counts as an actor, so it will have an actorID
	private static final ActorIdType partyID = new ActorIdType();

	//Initialize the logger that we will use
	private static final Logger logger = LogManager.getLogger(LocalMarketAgentRESTController.class);


	/**
	 * Here we will manage all active actors in the system. The actorID is used as a 
	 * key in this hashmap, and it's value is the URI that we would post to in the event
	 * that we want to
	 */
	ConcurrentHashMap<ActorIdType, String> MuaURIs = new ConcurrentHashMap(); 


	/**
	 * Simple no args constructor
	 */
	public LocalMarketAgentRESTController(){
		logger.trace("Zero argument constructor invoked");
	}

	
	/**
	 * Give the partyID back when requested
	 */
	@GetMapping("/party")
	public ActorIdType getPartyId(){
		return LocalMarketAgentRESTController.partyID;
	}


	/**
	 * A private helper that will insert the actor into our known actors list
	 */
	private void registerActor(ActorIdType actorId){

	}


	@PostMapping("/registerActor")
	public RegisterActorResponse registerActor(){
		return null;
	}






}
