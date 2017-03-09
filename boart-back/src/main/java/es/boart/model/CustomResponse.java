package es.boart.model;

public class CustomResponse {
	
	int code;
	String message;
	/**
	 * @param code
	 * @param message
	 */
	public CustomResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
