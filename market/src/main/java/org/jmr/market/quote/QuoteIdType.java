package org.jmr.market.quote;

import org.jmr.market.util.UIDType;

public class QuoteIdType extends UIDType{

	//JSON
	public QuoteIdType(){}

	public QuoteIdType(long id){
		super.setId(id);
	}

	@Override
	public int hashCode(){
		return super.hashCode();
	}

	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		}

		if(other.getClass() != QuoteIdType.class){
			return false;
		}

		return ((QuoteIdType)other).getId() == this.getId();
	}

	@Override
	public String toString(){
		return "QuoteIdType: " + super.toString();
	}
}
