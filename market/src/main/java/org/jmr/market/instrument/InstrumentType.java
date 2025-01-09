package org.jmr.market.instrument;


/**
 * Define an instrument type. Users can register their own instruments 
 * in this scheme. This will be stored in a mysql database
 */
public class InstrumentType{
	private InstrumentIdType instrumentId;

	private String instrumentName;
	private InstrumentAssetClass instrumentAssetClass;
	private InstrumentClass instrumentClass;
	private InstrumentPriceType instrumentPrice;
	/* May add more */

	//For JSON
	public InstrumentType(){}
	
	public InstrumentAssetClass getInstrumentAssetClass(){
		return this.instrumentAssetClass;
	}

	public void setInstrumentAssetClass(InstrumentAssetClass instrumentAssetClass){
		this.instrumentAssetClass = instrumentAssetClass;
	}

	public InstrumentClass getInstrumentClass(){
		return this.instrumentClass;
	}

	public void setInstrumentClass(InstrumentClass instrumentClass){
		this.instrumentClass = instrumentClass;
	}

	public InstrumentIdType getInstrumentId(){
		return this.instrumentId;
	}

	public void setInstrumentId(InstrumentIdType instrumentId){
		this.instrumentId = instrumentId;
	}

	public String getInstrumentName(){
		return this.instrumentName;
	}

	public void setInstrumentPrice(InstrumentPriceType instrumentPrice){
		this.instrumentPrice = instrumentPrice;
	}

	public InstrumentPriceType getInstrumentPrice(){
		return this.instrumentPrice;
	}

	public void setInstrumentName(String instrumentName){
		this.instrumentName = instrumentName;
	}

	@Override
	public String toString(){
		return "Instrument: {\n" + 
				this.instrumentId.toString() + 
				", " + this.instrumentName + 
				", " + this.instrumentClass +
				", " + this.instrumentAssetClass +
				", " + this.instrumentPrice.toString() +
				" }";
	}
}
