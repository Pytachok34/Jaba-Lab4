import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {
    public String read(Path targetFilePath) {
        try {
            return Files.readString(targetFilePath);
        } catch (final IOException ioe) {
            System.err.println(ioe.getMessage());
            return "";
        }
    }


}
