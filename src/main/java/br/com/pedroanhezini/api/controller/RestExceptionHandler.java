package br.com.pedroanhezini.api.controller;

import br.com.pedroanhezini.api.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleAny(RuntimeException ex, WebRequest request) {
        var body = ResponseError.builder()
                .key("internal.error")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(value = PersonNotFoundException.class)
    protected ResponseEntity<Object> handle(PersonNotFoundException ex, WebRequest request) {
        var body = ResponseError.builder()
                .key("not.found")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }


}
