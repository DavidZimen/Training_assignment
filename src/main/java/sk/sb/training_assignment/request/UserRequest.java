package sk.sb.training_assignment.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

/**
 * Class that is used to provide information from Client for making user with address.
 * @author <a href="https://github.com/DavidZimen">Dávic Zimen</a>
 */
@Getter @Setter @NoArgsConstructor
public class UserRequest {
    /**
     * User's name.
     */
    private String name;
    /**
     * User's surname.
     */
    private String surname;
    /**
     * User's date of birth.
     */
    private Date birthDate;

    /**
     * User's address street.
     */
    private String street;
    /**
     * User's address house number.
     */
    private int houseNumber;
    /**
     * User's address city.
     */
    private String city;
}
