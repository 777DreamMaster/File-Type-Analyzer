import search.Finder;
import search.RKSearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    private static final Finder finder = new Finder();

    private final File file;
    private final List<FilePattern> patterns;

    public Task(File file, List<FilePattern> patterns) {
        finder.setMethod(new RKSearch());
        this.file = file;
        this.patterns = patterns;
    }

    @Override
    public String call() throws IOException {
        String str = new String(Files.readAllBytes(file.toPath()));

        for (FilePattern pattern: patterns) {
            boolean isOfType = finder.find(str, pattern.getPattern());
            if (isOfType) return String.format("%s: %s", file.getName(), pattern.getSuccess());
        }

        return String.format("%s: %s", file.getName(), "Unknown file type");
    }
}
