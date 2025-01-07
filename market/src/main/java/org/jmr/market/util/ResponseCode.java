package org.jmr.market.util;


/**
 * Response codes for the market. These have a wide range, and will be added to
 * as we go
 */
public enum ResponseCode{
	RESPONSE_CODE_OK,
	GENERIC_ERROR,
	ACTOR_CREATION_FAILURE,
	ACTOR_NOT_FOUND,
	INSTRUMENT_NOT_FOUND,
	INVALID_ACTORID_STRING;


	private ResponseCode(){}
}
