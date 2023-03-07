package lab3;

public class PersonToCompanyRelation extends Relations {
    PersonToCompanyRelation(String type){
        this.type = type;
    }
    @Override
    public String toString(){
        return this.type;
    }
}
