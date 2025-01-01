package org.jmr.market.types.idTypes;

/**
 * This type is used to identify transactions(trades) that occur in the market.
 * It like all other IDs is linked to the base UniversalID(UID)
 */
public class TransactionIdType extends UIDType{
	
	//For JACKSON only
	public TransactionIdType(){}


	@Override
	public String toString(){
		return "TransactionId: " + super.toString();
	}

}
