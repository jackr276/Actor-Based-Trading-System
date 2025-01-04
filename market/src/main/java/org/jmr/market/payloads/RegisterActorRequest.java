package org.jmr.market.payloads;

import org.jmr.market.util.IPv4Address;

/**
 * We need to be able to register an actor within the system
 */
public class RegisterActorRequest{
	private String info = "RegisterActorRequest";
	//The address of the actor
	private IPv4Address ipv4Address;

	//JSON
	public RegisterActorRequest(){}

	public void setIpv4Address(IPv4Address ipv4Address){
		this.ipv4Address = ipv4Address;
	}

	public IPv4Address getIpv4Address(){
		return this.ipv4Address;
	}

	public void setInfo(String info){
		this.info = info;
	}

	public String getInfo(){
		return this.info;
	}

	@Override
	public String toString(){
		return "RegisterActorRequest: " + ipv4Address.toString();
	}
}
