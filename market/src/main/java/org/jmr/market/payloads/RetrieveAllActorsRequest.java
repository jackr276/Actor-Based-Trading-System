package org.jmr.market.payloads;

/**
 * A request to retrieve all information about currently
 * engaged actors in the system
 */
public class RetrieveAllActorsRequest{
	private String info = "RetrieveAllActorsRequest";

	//JSON
	public RetrieveAllActorsRequest(){}

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
