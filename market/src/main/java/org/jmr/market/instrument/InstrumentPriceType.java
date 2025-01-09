package org.jmr.market.instrument;

/**
 * The price of an instrument type that can be given. The price is given using a long integer, and
 * then dividied by 10000 for the actual price in decimal
 */
public class InstrumentPriceType{
	private long price;

	//JSON
	public InstrumentPriceType(){}

	public long getPrice(){
		return this.price;
	}
	
	public void setPrice(long price){
		this.price = price;
	}

	public double getPriceDecimal(){
		return ((double)this.price) / 10000;
	}

	@Override
	public String toString(){
		return "InstrumentPrice: " + this.price;
	}
}


