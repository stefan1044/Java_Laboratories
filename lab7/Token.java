package lab7;

public class Token {
    private final int number;

    Token(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString(){
        return this.number + " ";
    }
}
