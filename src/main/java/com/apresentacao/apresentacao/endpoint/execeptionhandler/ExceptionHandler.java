package com.apresentacao.apresentacao.endpoint.execeptionhandler;

import com.apresentacao.apresentacao.endpoint.entity.ApiError;
import com.apresentacao.apresentacao.exception.ObjetoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value= ObjetoNotFoundException.class)
    protected ResponseEntity<Object> handleConflict(ObjetoNotFoundException ex) {
        return new ResponseEntity<>(new ApiError(ex.getErrorCode(), ex.getMensagem()), HttpStatus.NOT_FOUND);
    }

}
