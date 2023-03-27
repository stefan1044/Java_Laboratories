package lab5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Catalog {
    private final ArrayList<Document> documents;

    Catalog(ArrayList<Document> documents){
        this.documents=documents;
    }

    public ArrayList<Document> getDocuments() {

        return documents;
    }

    public void Save(String fileName) throws WrongPathException, IOException {
        File dir = new File(fileName);
        if (!dir.exists()){
            throw new WrongPathException("Wrong filepath provided!");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(fileName + "json"), this);
    }

    protected void addDocuments(Document document) {
        this.documents.add(document);
    }

}
