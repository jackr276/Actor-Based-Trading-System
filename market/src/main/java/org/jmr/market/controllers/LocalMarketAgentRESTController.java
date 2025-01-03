package org.jmr.market.controllers;

import org.jmr.market.payloads.RegisterActorResponse;
import org.jmr.market.util.ActorIdType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/local_market_agent")
public class LocalMarketAgentRESTController {




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
