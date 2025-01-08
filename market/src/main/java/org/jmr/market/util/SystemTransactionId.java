package org.jmr.market.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * A system transaction ID uniquely identifies transactions within the system.
 * It is separate from anything that extends the UIDType class, and as such may have collisions
 * with UIDType
 */
public class SystemTransactionId{
	//Our ID
	private long id = 0;
	//New ID counter
	private static final AtomicLong idCounter = new AtomicLong();

	//If we're given this constructor, we'll get the next one atomically
	public SystemTransactionId(long id){
		this.id = idCounter.addAndGet(id);
	}
	
	//Grab the next one after incrementing
	public SystemTransactionId(){
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
	 * The hash code in our case simply is the ID, it
	 * is guaranteed to be unique
	 */
	@Override
	public int hashCode(){
		return (int)this.id;
	}


	/**
	 * String representation
	 */
	@Override
	public String toString(){
		return "System Transaction ID: " + String.valueOf(this.id);
	}
}
