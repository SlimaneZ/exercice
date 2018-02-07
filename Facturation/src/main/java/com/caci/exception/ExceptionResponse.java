package com.caci.exception;

/**
 * Classe regroupant le message et le code d'érreur.
 *  
 * @author Slimane
 *
 */
public class ExceptionResponse {
	
	private String errorCode;
    private String errorMessage;
 
    public ExceptionResponse() {
    }
 
    public String getErrorCode() {
        return errorCode;
    }
 
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
 
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
