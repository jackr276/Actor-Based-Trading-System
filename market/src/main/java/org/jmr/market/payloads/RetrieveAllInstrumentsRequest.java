package org.jmr.market.payloads;

/**
 * A request to retrieve all information about currently
 * engaged actors in the system
 */
public class RetrieveAllInstrumentsRequest{
	private String info = "RetrieveAllInstrumentsRequest";

	//JSON
	public RetrieveAllInstrumentsRequest(){}

	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	@Override
	public String toString(){
		return this.info;
	}
}
