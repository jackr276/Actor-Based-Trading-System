package org.jmr.market.payloads;

import org.jmr.market.instrument.InstrumentType;
import org.jmr.market.util.ResponseType;

public class RegisterInstrumentResponse{
	private String info = "RegisterInstrumentResponse";
	private InstrumentType instrument;
	private ResponseType response;

}
