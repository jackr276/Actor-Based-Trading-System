package org.jmr.market.types;

public class MarketTransactionIdType extends UIDType{
	//For JSON only
	public MarketTransactionIdType(){}

	@Override
	public String toString(){
		return "MarketTransactionID: " + super.toString();
	}
}
