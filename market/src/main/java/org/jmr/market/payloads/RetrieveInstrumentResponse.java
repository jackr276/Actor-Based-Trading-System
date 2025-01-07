package org.jmr.market.payloads;

import org.jmr.market.instrument.InstrumentType;
import org.jmr.market.util.ResponseType;

public class RetrieveInstrumentResponse{
	private String info = "RetrieveInstrumentResponse";
	//The instrument that we got
	private InstrumentType instrument;
	//The overall response
	private ResponseType response;

	//JSON
	public RetrieveInstrumentResponse(){}

	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public InstrumentType getInstrument(){
		return this.instrument;
	}

	public void setInstrument(InstrumentType instrument){
		this.instrument = instrument;
	}

	public ResponseType getResponse(){
		return this.response;
	}

	public void setResponse(ResponseType response){
		this.response = response;
	}

	@Override
	public String toString(){
		return this.info + ": " + this.instrument + ", " + this.response;
	}
}
