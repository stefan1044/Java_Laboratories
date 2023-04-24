package lab8;

import java.sql.SQLException;

public class Lab8 {

    public static void main(String[] args){
        var lab8 = new Lab8();

        lab8.compulsory();
    }

    private void compulsory(){
        try{
            Database.createConnection();
            var artists = new Artist();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");

            Database.closeConnection();
        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
