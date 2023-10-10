package com.project.apptarefas.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class Exceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> notFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValid(MethodArgumentNotValidException ex){
//        var erros = ex.getFieldErrors();
//        System.out.println(erros);
//        return ResponseEntity.badRequest()
//                .body(erros
//                        .stream()
//                        .map(DadosErros::new)
//                        .collect(Collectors.toList()));

        var erros = ex.getFieldErrors().stream().map(DadosErros::new).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(erros);
    }
    public static class DadosErros{
        String message;
        String field;

        public DadosErros(FieldError erro){
            this.message = erro.getDefaultMessage();
            this.field = erro.getField();
        }
    }
}
