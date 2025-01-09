package org.jmr.market.payloads;

import org.jmr.market.instrument.*;

public class RegisterInstrumentRequest{
	private String info = "RegisterInstrumentRequest";
	private String instrumentName;
	private InstrumentAssetClass instrumentAssetClass;
	private InstrumentClass instrumentClass;
	private InstrumentPriceType instrumentPrice;
	/* May add more as needed */

	//JSON
	public RegisterInstrumentRequest(){}

	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public String getInstrumentName(){
		return this.instrumentName;
	}

	public void setInstrumentName(String instrumentName){
		this.instrumentName = instrumentName;
	}

	public InstrumentClass getInstrumentClass(){
		return this.instrumentClass;
	}

	public void setInstrumentClass(InstrumentClass instrumentClass){
		this.instrumentClass = instrumentClass;
	}

	public InstrumentAssetClass getInstrumentAssetClass(){
		return this.instrumentAssetClass;
	}

	public void setInstrumentAssetClass(InstrumentAssetClass instrumentAssetClass){
		this.instrumentAssetClass = instrumentAssetClass;
	}

	public InstrumentPriceType getInstrumentPrice(){
		return this.instrumentPrice;
	}

	public void setInstrumentPrice(InstrumentPriceType instrumentPrice){
		this.instrumentPrice = instrumentPrice;
	}

	@Override
	public String toString(){
		return this.info + " " + this.instrumentName + " " + this.instrumentAssetClass + " " + this.instrumentClass;
	}
	
}
