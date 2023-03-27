package lab5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Catalog {
    private final ArrayList<Document> documents;

    Catalog(){this.documents = new ArrayList<Document>();}
    Catalog(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public ArrayList<Document> getDocuments() {

        return documents;
    }

    public void save(String fileName) throws WrongPathException, IOException {
        File dir = new File(fileName);
        if (!dir.exists()) {
            throw new WrongPathException("Wrong filepath provided!");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(fileName + "json"), this);
    }

    protected void addDocuments(Document document) {
        this.documents.add(document);
    }

    @Override
    public String toString(){
        return this.documents.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

}
