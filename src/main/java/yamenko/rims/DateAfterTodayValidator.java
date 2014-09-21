package yamenko.rims;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Custom validator. Validated date should be after today's date.
 */
@FacesValidator(value = "dateAfterTodayValidator")
public class DateAfterTodayValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Date validatedDate = (Date) o; // convert to Date object

        // if validated date equals or before today's date
        if (validatedDate.compareTo(new Date()) <= 0) {
            FacesMessage message = new FacesMessage("Date should be after today's date");
            throw new ValidatorException(message);
        }
    }
}
