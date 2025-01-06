package org.jmr.market.controllers;

import org.jmr.market.payloads.RegisterActorRequest;
import org.jmr.market.payloads.RegisterActorResponse;
import org.jmr.market.payloads.RetrieveActorRequest;
import org.jmr.market.payloads.RetrieveActorResponse;
import org.jmr.market.payloads.RetrieveAllActorsRequest;
import org.jmr.market.payloads.RetrieveAllActorsResponse;
import org.jmr.market.util.ActorIdType;
import org.jmr.market.util.ActorType;
import org.jmr.market.util.ResponseCode;
import org.jmr.market.util.ResponseType;
import org.jmr.market.util.SystemTransactionId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
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


	//========================================= Actor Management System ======================================
	/**
	 * A request given to register an actor in the system. Before registration, actors 
	 * are unknown and the system will not recognize them
	 */
	@PostMapping("/registerActor")
	public RegisterActorResponse registerActor(
		@RequestBody RegisterActorRequest registerActorRequest){

		//Temporary variables
		RegisterActorRequest request = registerActorRequest;
		RegisterActorResponse registerResponse = new RegisterActorResponse();
		ResponseType response = new ResponseType();

		//Overall system transaction ID for logging
		SystemTransactionId systemTransactionId = new SystemTransactionId();
		response.setTransactionId(systemTransactionId);
		response.setResponseTime(Instant.now());


		//Create a new actor
		ActorType actor = new ActorType();
		//Generate a new unique ID
		actor.setActorId(new ActorIdType());

		//If the address is bad
		if(request.getIpv4Address().isValid() == false){
			logger.error("Invalid IP address of " + request.getIpv4Address().getAddress() 
				+ " provided. Actor will not be registered");	
			response.setResponseCode(ResponseCode.ACTOR_CREATION_FAILURE);
			response.setResponseDescription("Invalid IP address given for actor");
		} else {
			//Set the address if it's valid
			actor.setActorAddress(request.getIpv4Address());
			actor.setPort(request.getPort());
		
			//We now have a valid actor, so we're good to insert
			currentActors.put(actor.getActorId(), actor);
			response.setResponseCode(ResponseCode.RESPONSE_CODE_OK);
			response.setResponseDescription("Actor has been created and registered");
		}

		registerResponse.setResponse(response);
		registerResponse.setActor(actor);

		//Success message
		logger.info("Local Market Agent successfully created actor: " + actor.toString());

		return registerResponse;
	}

	/**
	 * Retrieve an actor with the corresponding ID from the current actor system
	 */
	@PostMapping("/retrieveActor")
	public RetrieveActorResponse retrieveActor(
		@RequestBody RetrieveActorRequest retrieveActorRequest){

		//Overall transaction ID
		SystemTransactionId systemTransactionId = new SystemTransactionId();
		//Temp variable to hold the request
		RetrieveActorRequest request = retrieveActorRequest;
		RetrieveActorResponse retrieveResponse = new RetrieveActorResponse();
		//Response type for holding info
		ResponseType response = new ResponseType();
		response.setTransactionId(systemTransactionId);
		response.setResponseTime(Instant.now());

		//Invoke this for searching
		ActorIdType actorId = new ActorIdType(request.getActorId());

		ActorType found = null;
		//Let's see if we can grab it
		found = currentActors.get(actorId);
		
		//Set the actor here
		retrieveResponse.setActor(found);
		
		if(found == null){
			response.setResponseCode(ResponseCode.ACTOR_NOT_FOUND);
			response.setResponseDescription("Actor with ID " + actorId.toString() + " does not exist");
			logger.info("Actor with ID " + actorId.toString() + " does not exist");
		} else {
			response.setResponseCode(ResponseCode.RESPONSE_CODE_OK);
			response.setResponseDescription("Actor with ID " + actorId.toString() + " was found");
			logger.info("Actor with ID " + actorId.toString() + " was found");
		}

		//Set and get out
		retrieveResponse.setResponse(response);
		return retrieveResponse;
	}


	/**
	 * Retrieve an actor with the corresponding ID from the current actor system
	 */
	@PostMapping("/retrieveAllActors")
	public RetrieveAllActorsResponse retrieveAllActors(
		@RequestBody RetrieveAllActorsRequest retrieveAllActorsRequest){
		//Overall transaction ID
		SystemTransactionId systemTransactionId = new SystemTransactionId();
		//Temp variable to hold the request
		RetrieveAllActorsResponse retrieveResponse = new RetrieveAllActorsResponse();
		//To hold all of our actors
		ArrayList<ActorType> actors = new ArrayList<>();

		//Response type for holding info
		ResponseType response = new ResponseType();
		response.setTransactionId(systemTransactionId);
		response.setResponseTime(Instant.now());
		response.setResponseCode(ResponseCode.RESPONSE_CODE_OK);

		//Build the array list up for us to respond
		for(ActorIdType id : this.currentActors.keySet()){
			actors.add(this.currentActors.get(id));
		}

		//Add it in to the response
		retrieveResponse.setActors(actors);
		retrieveResponse.setResponse(response);
		
		//We should now be all set to return
		return retrieveResponse;
	}


	//========================================= Actor Management System ======================================
}
