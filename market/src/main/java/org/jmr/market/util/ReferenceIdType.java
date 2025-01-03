package org.jmr.market.util;

/**
 * This referenceID is used to uniquely identify things like responses, and other
 * miscellaneous items in the market
 */
public class ReferenceIdType extends UIDType{
	
	//For JACKSON only
	public ReferenceIdType(){}


	@Override
	public String toString(){
		return "ReferenceId: " + super.toString();
	}

}
