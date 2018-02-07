package com.caci.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.caci.service.MessageService;


/**
  * Classe permettant de centraliser la gestion es exceptions.
  * Elle permet de mapper plusieurs exceptions vers  une seule méthode. 
  * 
  * @author Slimane
  *
  */
@ControllerAdvice
public class ExceptionHandlingController {
	
	@Autowired
    private MessageService messageByLocaleService;

 
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(messageByLocaleService.getMessage("not.found"));
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
