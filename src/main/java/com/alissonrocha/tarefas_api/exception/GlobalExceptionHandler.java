package com.alissonrocha.tarefas_api.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleUncaught(PropertyReferenceException ex, HttpServletRequest request) {
        log.error("API exception in {}", request.getRequestURI(), ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                "Erro Inesperado",
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                request.getRequestURI(),
                OffsetDateTime.now()
        );
        return ResponseEntity.internalServerError().body(exceptionResponse);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFound(PropertyReferenceException ex, HttpServletRequest request) {
        log.error("API exception in {}", request.getRequestURI(), ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                "Entidade Não Encontrada",
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                OffsetDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
}