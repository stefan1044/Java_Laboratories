package lab5;

public class ListCommand implements Command{
    public void execute(Catalog catalog){
        var documents = catalog.getDocuments();

        for(var document:documents){
            System.out.println(document);
        }
    }
}
