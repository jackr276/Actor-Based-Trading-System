package org.jmr.market.util;

import java.util.regex.*;

/**
 * A class that will represent IPv4 addresses
 */
public class IPv4Address{
	//The actual address
	private String address;
	//Is it valid?
	private boolean isValid;

	//JSON
	public IPv4Address(){}


	/**
	 * Will also check if the address is valid
	*/
	public void setAddress(String address){
		this.address = address;
		this.isValid = isAddressValid();
	}

	public String getAddress(){
		return this.address;
	}

	public boolean isValid(){
		return this.isValid();
	}

	/**
	 * Is the address a valid IPv4 address?
	 */
	private boolean isAddressValid(){
		//We can always have localhost
		if(address.equals("localhost")){
			return true;
		}

		Pattern pattern = Pattern.compile("[0-9]{1, 3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}");
		Matcher m = pattern.matcher(this.address);
		
		//Is it a valid IPv4 address?
		return m.find();
	}

	@Override
	public String toString(){
		return "IPv4 Address: " + this.address.toString();
	}

}
