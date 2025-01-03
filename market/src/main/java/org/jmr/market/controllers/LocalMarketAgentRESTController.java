package org.jmr.market.controllers;

import org.jmr.market.payloads.RegisterActorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/local_market_agent")
public class LocalMarketAgentRESTController {

	@PostMapping("/registerActor")
	public RegisterActorResponse registerActor(){
		return null;
	}






}
