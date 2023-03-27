package lab5;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Lab5 {

    public static void main(String[] args) {
        Lab5 lab5 = new Lab5();

        lab5.compulsory();
        lab5.homework();
        lab5.bonus();
    }

    private void compulsory() {

    }

    private void homework() {
        Document d1 = new Document(2,"Map",new HashMap<>(2),".",".");
        ArrayList<Document> tempList = new ArrayList<>();
        tempList.add(d1);

        Catalog c1 = new Catalog(tempList);
        try {
            c1.Save("C:\\Users\\k\\IdeaProjects\\IP_Lab_1\\src\\testFile.txt");
        }
        catch (IOException e){
            System.out.println("Error when accessing filepath!");
            System.exit(1);
        }
    }

    private void bonus() {

    }

}
