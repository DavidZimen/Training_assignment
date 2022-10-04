package sk.sb.training_assignment.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class UserRequest {
    private String name;
    private String surname;
    private Date birthDate;

    private String street;
    private int houseNumber;
    private String city;
}
