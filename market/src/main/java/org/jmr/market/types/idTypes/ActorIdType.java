package org.jmr.market.types.idTypes;

public class ActorIdType extends UIDType{
	//For JSON only
	public ActorIdType(){}

	@Override
	public String toString(){
		return "ActorID: " + super.toString();
	}
}
