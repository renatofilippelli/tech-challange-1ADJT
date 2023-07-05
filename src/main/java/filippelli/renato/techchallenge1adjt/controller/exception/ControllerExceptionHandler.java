package filippelli.renato.techchallenge1adjt.controller.exception;

import filippelli.renato.techchallenge1adjt.service.exception.ControllerNotFoundException;
import filippelli.renato.techchallenge1adjt.service.exception.DatabaseException;
import filippelli.renato.techchallenge1adjt.service.exception.DefaultError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    private DefaultError err = new DefaultError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<DefaultError> entityNotFound(ControllerNotFoundException e, HttpServletRequest r) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Entity not found");
        err.setMessage(e.getMessage());
        err.setPath(r.getRequestURI());
        return ResponseEntity.status(status).body(this.err);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<DefaultError> entityNotFound(DatabaseException e, HttpServletRequest r) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Database error");
        err.setMessage(e.getMessage());
        err.setPath(r.getRequestURI());
        return ResponseEntity.status(status).body(this.err);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FormValidation> validation(MethodArgumentNotValidException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        FormValidation formValidation = new FormValidation();
        formValidation.setTimestamp(Instant.now());
        formValidation.setStatus(status.value());
        formValidation.setError("Validation Error");
        formValidation.setMessage(exception.getMessage());
        formValidation.setPath(request.getRequestURI());

        for (FieldError field: exception.getBindingResult().getFieldErrors()) {
            formValidation.addMessages(field.getField(), field.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(formValidation);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<FormValidation> validation(MethodArgumentTypeMismatchException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        FormValidation formValidation = new FormValidation();
        formValidation.setTimestamp(Instant.now());
        formValidation.setStatus(status.value());
        formValidation.setError("Invalid UUID");
        formValidation.setMessage(exception.getMessage());
        formValidation.setPath(request.getRequestURI());

        formValidation.addMessages(exception.getName(),
                "Should be of type " + exception.getRequiredType().getName());

        return ResponseEntity.status(status).body(formValidation);
    }
}
