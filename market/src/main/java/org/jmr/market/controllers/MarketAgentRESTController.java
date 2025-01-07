package org.jmr.market.controllers;

import org.jmr.market.instrument.InstrumentIdType;
import org.jmr.market.instrument.InstrumentType;
import org.jmr.market.payloads.ActorDoesNotExistResponse;
import org.jmr.market.payloads.ActorResponse;
import org.jmr.market.payloads.RegisterActorRequest;
import org.jmr.market.payloads.RegisterActorResponse;
import org.jmr.market.payloads.RegisterInstrumentRequest;
import org.jmr.market.payloads.RegisterInstrumentResponse;
import org.jmr.market.payloads.RetrieveActorRequest;
import org.jmr.market.payloads.RetrieveActorResponse;
import org.jmr.market.payloads.RetrieveAllActorsRequest;
import org.jmr.market.payloads.RetrieveAllActorsResponse;
import org.jmr.market.payloads.RetrieveAllInstrumentsRequest;
import org.jmr.market.payloads.RetrieveAllInstrumentsResponse;
import org.jmr.market.payloads.RetrieveInstrumentRequest;
import org.jmr.market.payloads.RetrieveInstrumentResponse;
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
@RequestMapping("/market_agent")
public class MarketAgentRESTController {
	//In our system, the LMA itself counts as an actor, so it will have an actorID
	private static final ActorIdType partyID = new ActorIdType();

	//Initialize the logger that we will use
	private static final Logger logger = LogManager.getLogger(MarketAgentRESTController.class);


	/**
	 * Here we will manage all active actors in the system. The actorID is used as a 
	 * key in this hashmap, and it's value is the URI that we would post to in the event
	 * that we want to
	 */
	ConcurrentHashMap<ActorIdType, ActorType> currentActors = new ConcurrentHashMap<>(); 
	/**
	 * Here we will manage all active instruments in the system. The instrumentID is used as a 
	 * key in this hashmap
	 * TODO will eventually go in database
	 */
	ConcurrentHashMap<InstrumentIdType, InstrumentType> currentInstruments = new ConcurrentHashMap<>(); 



	/**
	 * Simple no args constructor
	 */
	public MarketAgentRESTController(){
		logger.trace("Zero argument constructor invoked");
	}

	
	/**
	 * Give the partyID back when requested
	 */
	@GetMapping("/party")
	public ActorIdType getPartyId(){
		return MarketAgentRESTController.partyID;
	}


	/**
	 * Is the actor that we're seeing something from currently registered
	 */

	/**
	 * The generic actor does not exist response that will be returned whenever we have a
	 * bad request
	 */
	private ActorDoesNotExistResponse actorDoesNotExistResponseBuilder(){
		ActorDoesNotExistResponse actorDoesNotExistResponse = new ActorDoesNotExistResponse();

		//Build and populate the response
		ResponseType response = new ResponseType();
		response.setTransactionId(new SystemTransactionId());
		response.setResponseDescription("Actor does not exist");
		response.setResponseTime(Instant.now());
		response.setResponseCode(ResponseCode.ACTOR_NOT_FOUND);

		actorDoesNotExistResponse.setResponse(response);
		
		//Send it out
		return actorDoesNotExistResponse;
	}

	//========================================= Actor Management System ======================================
	/**
	 * A request given to register an actor in the system. Before registration, actors 
	 * are unknown and the system will not recognize them
	 */
	@PostMapping("/registerActor")
	public ActorResponse registerActor(
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
	public ActorResponse retrieveActor(
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
			//Call and get out
			return actorDoesNotExistResponseBuilder();
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
	//==================================== Instrument Management System ======================================
	/**
	 * Register a new instrument
	 */
	@PostMapping("/registerInstrument")
	public RegisterInstrumentResponse registerInstrument(
		@RequestBody RegisterInstrumentRequest registerInstrumentRequest){
		RegisterInstrumentRequest request = registerInstrumentRequest;
		RegisterInstrumentResponse registerResponse = new RegisterInstrumentResponse();

		//Transaction ID
		SystemTransactionId systemTransactionId = new SystemTransactionId();

		//Populate response
		ResponseType response = new ResponseType();
		response.setTransactionId(systemTransactionId);
		response.setResponseTime(Instant.now());
		
		//Populate the instrument
		InstrumentType instrument = new InstrumentType();
		instrument.setInstrumentId(new InstrumentIdType());
		instrument.setInstrumentName(request.getInstrumentName());
		instrument.setInstrumentClass(request.getInstrumentClass());
		instrument.setInstrumentAssetClass(request.getInstrumentAssetClass());
		
		//Insert into the map
		currentInstruments.put(instrument.getInstrumentId(), instrument);
		
		//Populate response and return
		registerResponse.setInstrument(instrument);
		response.setResponseCode(ResponseCode.RESPONSE_CODE_OK);
		registerResponse.setResponse(response);

		return registerResponse;
	}
	
	/**
	 * Retrieve an instrument by ID
	 */
	@PostMapping("/retrieveInstrument")
	public RetrieveInstrumentResponse retrieveInstrument(
		@RequestBody RetrieveInstrumentRequest retrieveInstrumentRequest){
		RetrieveInstrumentRequest request = retrieveInstrumentRequest;
		RetrieveInstrumentResponse retrieveResponse = new RetrieveInstrumentResponse();

		//Transaction ID
		SystemTransactionId systemTransactionId = new SystemTransactionId();

		//Create an initially populate the response
		ResponseType response = new ResponseType();
		response.setTransactionId(systemTransactionId);
		response.setResponseTime(Instant.now());
		
		//Make this for searching
		InstrumentIdType instrumentId = new InstrumentIdType(request.getInstrumentId());
		InstrumentType found = null;

		//Let's see if we find it
		found = currentInstruments.get(instrumentId);

		//If we didn't find it
		if(found == null){
			response.setResponseCode(ResponseCode.INSTRUMENT_NOT_FOUND);
			response.setResponseDescription("Instrument with ID" + instrumentId + " does not exist");
		} else {
			//Otherwise we did find it
			response.setResponseCode(ResponseCode.RESPONSE_CODE_OK);
			response.setResponseDescription("Instrument with ID" + instrumentId + " was found");
		}
		
		//Whether we did or didn't populate the instrument
		retrieveResponse.setInstrument(found);
		//Populate the response
		retrieveResponse.setResponse(response);
		
		return retrieveResponse;
	}

	/**
	 * Retrieve all currently registered instruments
	 */
	@PostMapping("/retrieveAllInstruments")
	public RetrieveAllInstrumentsResponse retrieveAllInstruments(
		@RequestBody RetrieveAllInstrumentsRequest retrieveAllInstrumentsRequest){
		RetrieveAllInstrumentsResponse retrieveResponse = new RetrieveAllInstrumentsResponse();
		
		//Initialize response and transaction ID
		SystemTransactionId systemTransactionId = new SystemTransactionId();
		ResponseType response = new ResponseType();
		response.setTransactionId(systemTransactionId);
		response.setResponseTime(Instant.now());
		response.setResponseDescription("All currently registered instruments have been returned");
		
		//We'll populate this
		ArrayList<InstrumentType> instruments = new ArrayList<>();

		//Iterate over and populate
		for(InstrumentIdType i : currentInstruments.keySet()){
			instruments.add(currentInstruments.get(i));
		}
		
		response.setResponseCode(ResponseCode.RESPONSE_CODE_OK);
		
		//Populate and return
		retrieveResponse.setResponse(response);
		retrieveResponse.setInstruments(instruments);
		
		return retrieveResponse;
	}
	//==================================== Instrument Management System ======================================
}
