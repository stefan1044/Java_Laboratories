package lab5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {
    public Catalog execute(String fileName) throws IOException {
        var objectMapper = new ObjectMapper();
        File dir = new File(fileName);
        if (!dir.exists()) {
            throw new WrongPathException("Wrong filepath provided!");
        }

        return objectMapper.readValue(new File(fileName), Catalog.class);
    }
}
