package com.adritec96.apiCites.Share;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {

        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        StringBuilder errorMessage = new StringBuilder();
        fieldErrors.forEach(f -> errorMessage.append(f.getField() + " " + f.getDefaultMessage() +  " "));

        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), errorMessage.toString(), request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ErrorInfo> notFound( HttpServletRequest request, NotFound exception ){
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI() );
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<ErrorInfo> contentBodyNotValid(HttpServletRequest request, PropertyValueException e){
        String message = "ErrorBody: La propiedad " + e.getPropertyName() + " no tiene valor correcto.";
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), message , request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistRelation.class)
    public ResponseEntity<ErrorInfo> exist_relacion_medico_paciente (HttpServletRequest request, ExistRelation e){ ;
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage() , request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

}
