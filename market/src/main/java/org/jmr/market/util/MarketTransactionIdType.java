package org.jmr.market.util;

public class MarketTransactionIdType extends UIDType{
	//For JSON only
	public MarketTransactionIdType(){}

	@Override
	public String toString(){
		return "MarketTransactionID: " + super.toString();
	}
}
