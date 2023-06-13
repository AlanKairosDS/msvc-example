package com.spring.common.tools.config;

import com.spring.common.tools.entity.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(value = {NullPointerException.class})
  public ResponseEntity<RestResponse<Object>> nullPointerException (NullPointerException e, WebRequest request) {
    return new ResponseEntity<>(this.armarRespuesta(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
            HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {NumberFormatException.class})
  public ResponseEntity<RestResponse<Object>> numberFormatException (NumberFormatException e, WebRequest request) {
    return new ResponseEntity<>(this.armarRespuesta(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
            HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  public ResponseEntity<RestResponse<Object>> badRequestException (MethodArgumentNotValidException e,
          WebRequest request) {
    return new ResponseEntity<>(this.armarRespuesta(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
            HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {MethodNotAllowedException.class})
  public ResponseEntity<RestResponse<Object>> methodNotAllowedException (MethodNotAllowedException e,
          WebRequest request) {
    return new ResponseEntity<>(this.armarRespuesta(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getMessage()),
            HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(value = {MyOwnException.class})
  public ResponseEntity<RestResponse<Object>> myOwnException (Exception e, WebRequest request) {
    return new ResponseEntity<>(this.armarRespuesta(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public RestResponse<Object> armarRespuesta (int code, String message) {
    return RestResponse.builder()
            .code(code)
            .message("Hubo un error interno al procesar los datos")
            .description(message)
            .error(true)
            .data(null)
            .build();
  }
}
