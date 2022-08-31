import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Analyzer {

    private static final String baseName = System.getProperty("user.dir") + "/";
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void analyze(String[] args) throws InterruptedException, IOException, ExecutionException {
        String folderName = baseName + args[0];
        String patternsName = baseName + args[1];

        File[] files = new File(folderName).listFiles();
        List<FilePattern> patterns = FilePattern.getPatterns(patternsName);
        Collections.reverse(patterns);

        List<Callable<String>> callables = new ArrayList<>();

        for (File file: files) {
            callables.add(new Task(file, patterns));
        }

        List<Future<String>> futures = executor.invokeAll(callables);

        for (Future<String> value: futures) {
            System.out.println(value.get());
        }
        executor.shutdown();
    }
}
