package org.jmr.market.controllers;

import java.time.Instant;

import org.jmr.market.payloads.ActorCreateQuoteRequest;
import org.jmr.market.payloads.ActorCreateQuoteResponse;
import org.jmr.market.payloads.ActorDoesNotExistResponse;
import org.jmr.market.controllers.MarketAgentRESTController;
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
	private ActorResponse findActorById(String actorIdString){
		ResponseType response = new ResponseType();
		response.setResponseTime(Instant.now());
		response.setTransactionId(new SystemTransactionId());
		//We'll try to find this
		long actorId;

		//Try to parse the actorId given
		try{
			actorId = Long.parseLong(actorIdString);
		} catch (NumberFormatException nfe){
			//If it's bad, then we'll fail out
			ActorDoesNotExistResponse actorResponse = new ActorDoesNotExistResponse();
			response.setResponseCode(ResponseCode.INVALID_ACTORID_STRING);
			response.setResponseDescription("An invalid actorId string was given in the URI");
			actorResponse.setResponse(response);
			return actorResponse;
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
		System.out.println(actorResponse);


		return null;
	} 

	@PostMapping("{actorId}/createQuote")
	public ActorResponse actorCreateQuote(
		@PathVariable String actorId,
		@RequestBody ActorCreateQuoteRequest actorCreateQuoteRequest
	){
		findActorById(actorId);
			return null;
	}

}
