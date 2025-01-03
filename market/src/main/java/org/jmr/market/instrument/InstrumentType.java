package org.jmr.market.instrument;


/**
 * Define an instrument type. Users can register their own instruments 
 * in this scheme. This will be stored in a mysql database
 */
public class InstrumentType{
	private InstrumentIdType instrumentId;

	private String instrumentName;
	/* May add more */

	//For JSON
	public InstrumentType(){}
	
	public InstrumentIdType getInstrumentId(){
		return this.instrumentId;
	}

	public void setInstrumentId(InstrumentIdType instrumentId){
		this.instrumentId = instrumentId;
	}

	public String getInstrumentName(){
		return this.instrumentName;
	}

	public void setInstrumentName(String instrumentName){
		this.instrumentName = instrumentName;
	}

	@Override
	public String toString(){
		return "Instrument: {\n" + 
				this.instrumentId.toString() + 
				",\n" + this.instrumentName + 
				"\n}";
	}
	


}
