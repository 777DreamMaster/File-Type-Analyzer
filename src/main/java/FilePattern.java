import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilePattern {
    private final int priority;
    private final String pattern;
    private final String success;

    public FilePattern(int priority, String pattern, String success) {
        this.priority = priority;
        this.pattern = pattern;
        this.success = success;
    }

    public int getPriority() {
        return priority;
    }

    public String getPattern() {
        return pattern;
    }

    public String getSuccess() {
        return success;
    }

    public static List<FilePattern> getPatterns(String patternsName) throws IOException {
        List<FilePattern> list = new ArrayList<>();

        List<String> fileLines = Files.readAllLines(Paths.get(patternsName));

        for (String fileLine : fileLines) {
            fileLine = fileLine.replaceAll("\"","");
            String[] split = fileLine.split(";");
            list.add(new FilePattern(Integer.parseInt(split[0]), split[1], split[2]));
        }
        return list;
    }

    @Override
    public String toString() {
        return "FilePattern{" +
                "priority=" + priority +
                ", pattern='" + pattern + '\'' +
                ", success='" + success + '\'' +
                '}';
    }
}
