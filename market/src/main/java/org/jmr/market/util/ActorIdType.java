package org.jmr.market.util;

public class ActorIdType extends UIDType{
	//For JSON only
	public ActorIdType(){}


	@Override
	public int hashCode(){
		return super.hashCode();
	}

	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		}

		if(other.getClass() != ActorIdType.class){
			return false;
		}

		return ((ActorIdType)other).getId() != this.getId();
	}

	@Override
	public String toString(){
		return "ActorID: " + super.toString();
	}
}
