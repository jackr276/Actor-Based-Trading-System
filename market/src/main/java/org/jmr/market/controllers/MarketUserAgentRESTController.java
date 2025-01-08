package org.jmr.market.controllers;

import java.time.Instant;

import org.jmr.market.payloads.ActorCreateQuoteRequest;
import org.jmr.market.payloads.ActorCreateQuoteResponse;
import org.jmr.market.payloads.ActorDoesNotExistResponse;
import org.jmr.market.controllers.MarketAgentRESTController;
import org.jmr.market.util.ActorType;
import org.jmr.market.util.ResponseCode;
import org.jmr.market.util.ResponseType;
import org.jmr.market.util.SystemTransactionId;
import org.jmr.market.payloads.ActorResponse;
import org.jmr.market.payloads.RetrieveActorRequest;
import org.jmr.market.payloads.RetrieveActorResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/marketUserAgent")
public class MarketUserAgentRESTController {

	/**
	 * A private helper method that will find an actor by the ID given in
	 * the URI
	 */
	private ActorType findActorById(String actorIdString){
		//We'll try to find this
		long actorId;

		//Try to parse the actorId given
		try{
			actorId = Long.parseLong(actorIdString);
		} catch (NumberFormatException nfe){
			return null;
		}

		//Otherwise we know that it exists
		final RestTemplateBuilder builder = new RestTemplateBuilder();
		// scope is function postEiCreateTender
		RestTemplate restTemplate = builder.build();

		//Create this and set before we send it off
		RetrieveActorRequest request = new RetrieveActorRequest();
		request.setActorId(actorId);

		//Send this to the market agent
		RetrieveActorResponse actorResponse = restTemplate.postForObject(MarketAgentRESTController.MarketAgentURL + "/retrieveActor",
																 request,
																 RetrieveActorResponse.class);
		//We'll give this back to whoever is asking
		return actorResponse.getActor();
	} 

	

	/**
	 * To avoid having to encode the actor ID in JSON, each individual actor will post to a URI with their
	 * ID in the URI for the POST. This also means that if an actor is not registered, their POST will fail
	 */
	@PostMapping("{actorId}/createQuote")
	public ActorCreateQuoteResponse actorCreateQuote(
		@PathVariable String actorId,
		@RequestBody ActorCreateQuoteRequest actorCreateQuoteRequest
	){
		ActorCreateQuoteResponse actorCreateQuoteResponse = new ActorCreateQuoteResponse();
		//Start to populate this
		ResponseType response = new ResponseType();
		response.setTransactionId(new SystemTransactionId());
		response.setResponseTime(Instant.now());


		//Let's see if we can actually find this actor
		ActorType actor = findActorById(actorId);

		//If it's null then we've failed here
		if(actor.getActorId().valueOf() == -1){
			response.setResponseCode(ResponseCode.ACTOR_NOT_FOUND);
			response.setResponseDescription("Actor with ID: " + actorId + " does not exist");
			actorCreateQuoteResponse.setResponse(response);
			//Return this
			return actorCreateQuoteResponse;
		}


		return null;
	}
}
