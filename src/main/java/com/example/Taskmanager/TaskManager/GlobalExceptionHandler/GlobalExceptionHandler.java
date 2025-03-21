package com.example.Taskmanager.TaskManager.GlobalExceptionHandler;

;
import com.example.Taskmanager.TaskManager.TaskException.ListTaskNotFoundException;
import com.example.Taskmanager.TaskManager.TaskException.NullTaskException;
import com.example.Taskmanager.TaskManager.TaskException.StatusNotValidException;
import com.example.Taskmanager.TaskManager.TaskException.TaskNotFoundException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTaskNotFound(TaskNotFoundException ex){
        Map<String, String> IdNotFound = new HashMap<>();
        IdNotFound.put("Message",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(IdNotFound);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleBeanValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(NullTaskException.class)
    public ResponseEntity<Map<String, String>> handleNullTaskException(NullTaskException ex){
        Map<String, String> nullErro = new HashMap<>();
        nullErro.put("Message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nullErro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidEnum(HttpMessageNotReadableException ex){
        Map<String, String> error = new HashMap<>();
        if(ex.getCause().getMessage().contains("TaskPriority")){
            error.put("Message","Priority is not valid, please enter a priority from the List:[HIGH, LOW, MEDIUM");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        error.put("message","Error in Json deserialization.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ListTaskNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundListTasksForPriority(ListTaskNotFoundException ex){
        Map<String,String> error = new HashMap<>();
        error.put("Message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentType(MethodArgumentTypeMismatchException ex){
        Map<String,String> error = new HashMap<>();
        if(ex.getCause().getMessage().contains("TaskStatus")){
            error.put("Message", "Status type is not valid, please enter valid Status");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        error.put("Message", "Priority type is not valid, please enter valid priority");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(StatusNotValidException.class)
    public ResponseEntity<Map<String, String>> handleStatusNotValid(StatusNotValidException ex){
        Map<String,String> error = new HashMap<>();
        error.put("Message",ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
