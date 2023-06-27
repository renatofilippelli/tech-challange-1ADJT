package filippelli.renato.techchallange1adjt.domain.address.controller.exception;

import filippelli.renato.techchallange1adjt.domain.address.service.exception.ControllerNotFoundException;
import filippelli.renato.techchallange1adjt.domain.address.service.exception.DatabaseException;
import filippelli.renato.techchallange1adjt.domain.address.service.exception.DefaultError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {
    private DefaultError err = new DefaultError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<DefaultError> entityNotFound(ControllerNotFoundException e, HttpServletRequest r) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("entity not found");
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

}
