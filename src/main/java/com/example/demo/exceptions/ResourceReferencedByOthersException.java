package com.example.demo.exceptions;

public class ResourceReferencedByOthersException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceReferencedByOthersException(String message) {
        super(message);
    }
}
