package lab5;

public interface  Command {
    default void execute(){
        return;
    }
}
