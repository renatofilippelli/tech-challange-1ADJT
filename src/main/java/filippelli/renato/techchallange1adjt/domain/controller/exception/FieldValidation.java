package filippelli.renato.techchallange1adjt.domain.controller.exception;

public class FieldValidation {

    private String field;

    private String message;

    public FieldValidation(){}

    public FieldValidation(String field, String message){
        this.message = message;
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
