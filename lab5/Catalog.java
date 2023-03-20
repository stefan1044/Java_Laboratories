package lab5;

import java.util.ArrayList;

public class Catalog {
    private final ArrayList<Document> documents;

    Catalog(ArrayList<Document> documents){
        this.documents=documents;
    }

    public ArrayList<Document> getDocuments() {

        return documents;
    }

    public void addDocuments(Document document) {
        this.documents.add(document);
    }

    @Override
    public String toString(){
        return this.documents.toString();
    }
}
