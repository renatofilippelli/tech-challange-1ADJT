package filippelli.renato.techchallenge1adjt.controller.exception;

import filippelli.renato.techchallenge1adjt.service.exception.DefaultError;

import java.util.ArrayList;
import java.util.List;

public class FormValidation extends DefaultError {

    private List<FieldValidation> messages = new ArrayList<>();

    public List<FieldValidation> getMessages(){
        return this.messages;
    }

    public void addMessages(String field, String message) {
        messages.add(new FieldValidation(field, message));
    }
}
