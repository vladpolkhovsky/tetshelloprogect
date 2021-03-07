import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {
    public static String readAsString(String file) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            StringBuilder stringBuilder = new StringBuilder();
            lines.forEach(x -> stringBuilder.append(x).append('\n'));
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
