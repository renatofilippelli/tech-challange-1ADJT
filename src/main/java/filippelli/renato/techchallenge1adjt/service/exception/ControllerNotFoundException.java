package filippelli.renato.techchallenge1adjt.service.exception;

public class ControllerNotFoundException extends RuntimeException {
    public ControllerNotFoundException(String message){
        super(message);
    }
}
