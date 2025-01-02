package org.jmr.market.controllers;

import org.jmr.market.payloads.ActorRegisterInstrumentResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marketUserAgent")
public class MarketUserAgentRESTController {

	@PostMapping("{muaID}/registerInstrument")
	public ActorRegisterInstrumentResponse actorRegisterInstrument(){

		return null;
	}

}
