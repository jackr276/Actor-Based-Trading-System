package org.jmr.market.payloads;

public class RetrieveInstrumentRequest{
	private String info = "RetrieveInstrumentRequest";
	//The ID that we want in long form
	private long instrumentId;

	//JSON
	public RetrieveInstrumentRequest(){}

	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public long getInstrumentId(){
		return this.instrumentId;
	}

	public void setInstrumentId(long instrumentId){
		this.instrumentId = instrumentId;
	}

	@Override
	public String toString(){
		return this.info + ": " + this.instrumentId;
	}
}
