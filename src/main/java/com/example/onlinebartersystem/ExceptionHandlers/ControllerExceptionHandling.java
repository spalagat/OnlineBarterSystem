package com.example.onlinebartersystem.ExceptionHandlers;

import com.example.onlinebartersystem.Exceptions.DuplicateUserRecordException;
import com.example.onlinebartersystem.Exceptions.UserNameNotFoundException;
import com.example.onlinebartersystem.models.ExceptionResponseModel;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandling {

    @ExceptionHandler(UserNameNotFoundException.class)
    public ResponseEntity<Object> userNotFoundException(UserNameNotFoundException ex){
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateUserRecordException.class)
    public ResponseEntity<ExceptionResponseModel> duplicateUserException(DuplicateUserRecordException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseModel(HttpStatus.BAD_REQUEST,ex.getMessage(),LocalDate.now().toString()));

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> constraintViolationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;

    }
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ExceptionResponseModel> jwtExpirationException(ExpiredJwtException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseModel(HttpStatus.BAD_REQUEST,ex.getMessage(),LocalDate.now().toString()));
    }
}
