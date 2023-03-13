package lab3;

public class PersonToPersonRelation extends Relations {
    PersonToPersonRelation(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
