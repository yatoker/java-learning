package com.amadeus.epwr.exception;

import com.amadeus.epwr.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateCheckException.class)
    public final ResponseEntity<?> handleDuplicateCheckException(DuplicateCheckException ex, WebRequest request){
        List<String> details = new ArrayList<String>();
        details.add(ex.getLocalizedMessage());
        ErrorDetails error = new ErrorDetails("CONFLICT", details);

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleUnknownException(Exception ex, WebRequest request){
        List<String> details = new ArrayList<String>();
        details.add(ex.getLocalizedMessage());
        ErrorDetails error = new ErrorDetails("INTERNAL_SERVER_ERROR", details);

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
