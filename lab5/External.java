package lab5;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;


public class External {
    static void add(Catalog catalog, Document document) throws InvalidPathException {
        boolean isValid = true;
        if (document.getPath() != null) {
            try {
                Paths.get(document.getPath());
            } catch (InvalidPathException e) {
                isValid = false;
            }
        }

        if (!isValid) {
            throw new WrongPathException("Path for document:" + document + " is invalid!");
        }


        catalog.addDocuments(document);
    }

    static String toString(Catalog catalog) {
        return catalog.getDocuments().toString();
    }
}
