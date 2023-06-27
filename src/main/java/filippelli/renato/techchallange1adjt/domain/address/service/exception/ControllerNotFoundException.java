package filippelli.renato.techchallange1adjt.domain.address.service.exception;

public class ControllerNotFoundException extends RuntimeException {
    public ControllerNotFoundException(String message){
        super(message);
    }
}
