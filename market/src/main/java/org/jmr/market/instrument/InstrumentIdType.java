package org.jmr.market.instrument;

import org.jmr.market.util.UIDType;

/**
 * Users are allowed to define their own instruments with which to trade. As such,
 * we need an instrument ID type that allows instrument registration
 */
public class InstrumentIdType extends UIDType{
	//For JSON
	public InstrumentIdType(){}

	@Override
	public int hashCode(){
		return super.hashCode();
	}

	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		}

		if(other.getClass() != InstrumentIdType.class){
			return false;
		}

		return ((InstrumentIdType)other).getId() == this.getId();
	}

	@Override
	public String toString(){
		return "Instrument ID: " + super.toString();
	}

}
