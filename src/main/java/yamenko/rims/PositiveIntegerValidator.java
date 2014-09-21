package yamenko.rims;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Custom validator. Validated integer should be positive.
 */
@FacesValidator(value = "positiveIntegerValidator")
public class PositiveIntegerValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Integer validatedInteger = (Integer) o; // convert to Integer object

        // if validated integer is negative
        if (validatedInteger < 0) {
            FacesMessage message = new FacesMessage("Integer should be positive");
            throw new ValidatorException(message);
        }
    }
}
