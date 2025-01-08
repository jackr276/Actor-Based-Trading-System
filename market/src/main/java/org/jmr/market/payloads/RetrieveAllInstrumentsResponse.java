package org.jmr.market.payloads;

import java.util.List;

import org.jmr.market.instrument.InstrumentType;
import org.jmr.market.util.ResponseType;

/**
 * The response will contain a list of actors that we have
 */
public class RetrieveAllInstrumentsResponse{
	private String info = "RetrieveAllInstrumentsResponse";
	private List<InstrumentType> instruments;
	private ResponseType response;

	//JSON
	public RetrieveAllInstrumentsResponse(){}

	public ResponseType getResponse(){
		return this.response;
	}

	public void setResponse(ResponseType response){
		this.response = response;
	}


	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public void setInstruments(List<InstrumentType> instruments){
		this.instruments = instruments;
	}

	public List<InstrumentType> getInstruments(){
		return this.instruments;
	}

	@Override
	public String toString(){
		return this.info + ": Instruments: " + this.instruments.toString();
	}
}
