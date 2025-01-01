package org.jmr.market.util;

public class ActorIdType extends UIDType{
	//For JSON only
	public ActorIdType(){}

	@Override
	public String toString(){
		return "ActorID: " + super.toString();
	}
}
