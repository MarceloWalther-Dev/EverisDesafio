/**
 * 
 */
package br.com.everis.challengeEveris.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mwalther
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BagNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public BagNotFoundException(String message) {
		super(message);
	}
}
