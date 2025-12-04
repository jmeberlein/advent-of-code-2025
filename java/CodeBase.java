import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CodeBase {
    public static List<String> load(String file) {
        try (
            BufferedReader in = new BufferedReader(new FileReader(file))
        ) {
            return in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            return List.of();
        }
    }
}
