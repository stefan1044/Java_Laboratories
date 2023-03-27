package lab5;

import javax.print.Doc;
import java.util.HashMap;

public class Document {

    private final int id;
    private final String name;

    private final HashMap<String, String> tags;
    private final String path;
    private final String link;

    Document(){
        this.id = 0;
        this.name = "";
        this.tags = new HashMap<String, String >();
        this.path = "";
        this.link = "";
    }
    Document(int id, String name, HashMap<String, String> tags, String path, String link) {
        this.id = id;
        this.tags = tags;
        this.name = name;
        this.path = path;
        this.link = link;
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
    public String toString() {
        return "Document with ID: " + this.id + ", name: " + this.name + ", tags: " + this.tags + ", at path: " + this.path;
    }

    public String getLink() {
        return link;
    }
}
