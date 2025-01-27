package com.SpringBasicRest.BasicRest.exception;

import com.SpringBasicRest.BasicRest.User.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class CustomizedResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

             @ExceptionHandler(Exception.class)
             public final ResponseEntity handleAllException(Exception ex, WebRequest request) {
                 ExceptionResponse exceptionResponse=  new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
                 return  new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

             }

             @ExceptionHandler(Exception.class)
             public final ResponseEntity handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
                ExceptionResponse exceptionResponse=  new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
                return  new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

            }


            @Override
            protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

                ExceptionResponse exceptionResponse=  new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString(),
                        request.getDescription(false));
                return  new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }



    }


