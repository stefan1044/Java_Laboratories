package lab5;

import java.util.HashMap;

public class Document {

    private final int id;
    private final String name;

    private final HashMap<String, String> tags;
    private final String path;

    Document(int id, String name, HashMap<String, String> tags, String path){
        this.id=id;
        this.tags =tags;
        this.name=name;
        this.path=path;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTags() {
        return tags;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString(){
        return "Document with ID: " + this.id + ", name: " + this.name + ", tags: " + this.tags + ", at path: " +
                this.path;
    }
}
