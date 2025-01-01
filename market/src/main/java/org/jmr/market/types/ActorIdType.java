package org.jmr.market.types;

public class ActorIdType extends UIDType{
	//For JSON only
	public ActorIdType(){}

	@Override
	public String toString(){
		return "ActorID: " + super.toString();
	}
}
