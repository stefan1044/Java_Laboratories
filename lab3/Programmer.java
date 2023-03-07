package lab3;

import java.util.Date;

public class Programmer extends Person{

    private final programingLanguages programingLanguage;
    Programmer(String name, Date birthdate, programingLanguages programingLanguage) {
        super(name, birthdate);
        this.programingLanguage = programingLanguage;
    }
}
