package org.jmr.market.controllers;

import org.jmr.market.payloads.RegisterActorRequest;
import org.jmr.market.payloads.RegisterActorResponse;
import org.jmr.market.util.ActorIdType;
import org.jmr.market.util.ActorType;
import org.jmr.market.util.IPv4Address;
import org.jmr.market.util.ResponseCode;
import org.jmr.market.util.ResponseType;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
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
	ConcurrentHashMap<ActorIdType, ActorType> currentActors = new ConcurrentHashMap<ActorIdType, ActorType>(); 


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
	 * A request given to register an actor in the system. Before registration, actors 
	 * are unknown and the system will not recognize them
	 */
	@PostMapping("/registerActor")
	public RegisterActorResponse registerActor(
		@RequestBody RegisterActorRequest registerActorRequest){

		//TODO rename refID to systemTransactionID
		
		//Build the REST template
		final RestTemplateBuilder builder = new RestTemplateBuilder();
		RestTemplate restTemplate = builder.build();

		//Temporary variables
		RegisterActorRequest request = registerActorRequest;
		RegisterActorResponse registerResponse = new RegisterActorResponse();
		ResponseType response = new ResponseType();


		//Create a new actor
		ActorType actor = new ActorType();
		//Generate a new unique ID
		actor.setActorId(new ActorIdType());

		//If the address is bad
		if(request.getIpv4Address().isValid() == false){
			logger.error("Invalid IP address of " + request.getIpv4Address().getAddress() 
				+ " provided. Actor will not be registered");	
			response.setResponseTime(Instant.now());
			response.setResponseCode(ResponseCode.GENERIC_ERROR);
			//response.setReferenceId(ne);
		}

		//Set the address if it's valid
		actor.setActorAddress(request.getIpv4Address());
		
		//We now have a valid actor, so we're good to insert
		currentActors.put(actor.getActorId(), actor);



		

		return null;
	}






}
