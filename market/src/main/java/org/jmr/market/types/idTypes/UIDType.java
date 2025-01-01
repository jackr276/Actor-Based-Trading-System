package org.jmr.market.types.idTypes;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This class represents a universal ID type that we will use to identify
 * basically everything. Universal ID types are important for systems that can
 * use concurrency because they allow us to ensure complete distinction between
 * certain objects
 */
public class UIDType{
	//Our ID
	private long id = 0;
	//New ID counter
	private static final AtomicLong idCounter = new AtomicLong();

	//If we're given this constructor, we'll get the next one atomically
	protected UIDType(long id){
		this.id = idCounter.addAndGet(id);
	}
	
	//Grab the next one after incrementing
	protected UIDType(){
		this.id = idCounter.incrementAndGet();
	}

	/**
	 * Grab the long value of the UID
	 */
	public long valueOf(){
		return this.id;
	}


	/**
	 * Explicitly for JACKSON serializing
	 */
	public long getId(){
		return this.id;
	}


	/**
	 * This is only intended to be used in the case where you want to forcibly
	 * override the atomic creation and set it yourself
	 */
	public void setId(long id){
		this.id = id;
	}

	 
	/**
	 * String representation
	 */
	public String toString(){
		return "Universal ID: " + String.valueOf(this.id);
	}
}
