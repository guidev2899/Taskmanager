package com.example.Taskmanager.TaskManager.GlobalExceptionHandler;

;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleEnumConversionError(HttpMessageNotReadableException ex){
        String messageError = "\"Valor inválido para status ou prioridade. Use apenas os valores permitidos: \" +\n" +
                "                \"Status: [PENDING, INPROGRESS, COMPLETED], \" +\n" +
                "                \"Prioridade: [LOW, MEDIUM, HIGH].\"";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageError);
    }

}
