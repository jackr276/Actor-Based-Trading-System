package org.jmr.market.controllers;

import org.jmr.market.payloads.ActorRegisterInstrumentResponse;
import org.jmr.market.payloads.ActorCreateQuoteRequest;
import org.jmr.market.payloads.ActorCreateQuoteResponse;
import org.jmr.market.payloads.ActorRegisterInstrumentRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marketUserAgent")
public class MarketUserAgentRESTController {

	@PostMapping("{muaID}/registerInstrument")
	public ActorRegisterInstrumentResponse actorRegisterInstrument(
		@PathVariable String muaID,
		@RequestBody ActorRegisterInstrumentRequest actorRegisterInstrumentRequest
	){
		


		return null;
	}


	@PostMapping("{muaID}/createQuote")
	public ActorCreateQuoteResponse actorCreateQuote(
		@PathVariable String muaID,
		@RequestBody ActorCreateQuoteRequest actorCreateQuoteRequest
	){
		return null;
	}

}
