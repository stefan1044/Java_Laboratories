package lab3;

import java.util.Date;

public class Designer extends Person{
    private final int yearsOfExperience;
    Designer(String name, Date birthdate, int yearsOfExperience) {
        super(name, birthdate);
        this.yearsOfExperience = yearsOfExperience;
    }
}
