package lab3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        Lab3 lab3 = new Lab3();

        lab3.compulsory();
        lab3.homework();
        lab3.bonus();
    }

    void compulsory() {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

        Date date1 = null;
        try {
            date1 = dateFormatter.parse("30-09-2002");
        } catch (ParseException e) {
            System.out.println("Parse exception when formatting string: " + e.getMessage());
        }

        Node p1 = new Person("Stefan", date1);
        Node c1 = new Company("Microsoft", 8_000_000);


        List<Node> list = new ArrayList<>();
        list.add(p1);
        list.add(c1);

        System.out.println(list);
    }

    void homework() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

        Date date2 = null;
        Date date3 = null;
        Date date4 = null;
        try {
            date2 = dateFormatter.parse("30-09-2002");
            date3 = dateFormatter.parse("05-04-2002");
            date4 = dateFormatter.parse("02-05-2003");
        } catch (ParseException e) {
            System.out.println("Parse exception when formatting string: " + e.getMessage());
        }

        Person p1 = new Person("Stefan", date2);
        Person p2 = new Person("Rares", date3);
        Person p3 = new Person("Mihai", date4);
        Company c1 = new Company("Microsoft", 8_000_000);
        Company c2 = new Company("Facebook", 10_000_000);

        p1.addRelation(p2, new PersonToPersonRelation("Friends"));
        p1.addRelation(p3, new PersonToPersonRelation("Enemies"));
        p1.addRelation(c1, new PersonToCompanyRelation("Engineer"));
        p2.addRelation(c1, new PersonToCompanyRelation("Programmer"));
        p2.addRelation(c2, new PersonToCompanyRelation("Cleaner"));
        p3.addRelation(c2, new PersonToCompanyRelation("Advisor"));


        Network network = new Network(new ArrayList<>());

        network.addNode(p1);
        network.addNode(p2);
        network.addNode(p3);
        network.addNode(c1);
        network.addNode(c2);

        System.out.println(network.getSortedImportanceList());

    }

    void bonus() {
        NetworkTest test = new NetworkTest();

        test.articulationPoints();
    }
}
