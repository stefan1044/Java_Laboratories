package lab5;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {
    public void execute(String fileName) throws IOException {
        File dir = new File(fileName);
        if (!dir.exists()) {
            throw new WrongPathException("Wrong filepath provided!");
        }

        Desktop.getDesktop().open(dir);
    }
}
