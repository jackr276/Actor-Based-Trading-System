package org.jmr.market.controllers;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.jmr.market.quote.QuoteIdType;
import org.jmr.market.quote.QuoteType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marketEngine")
public class MarketEngineRESTController {
	//The QDM is composed of all currently trading quotes
	private HashMap<QuoteIdType, QuoteType> currentQuotes;



}
