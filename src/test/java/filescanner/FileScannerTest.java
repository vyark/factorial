package filescanner;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class FileScannerTest {

    private FileScanner fileScanner = new FileScanner();

    @Test
    public void test() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(3);

        forkJoinPool.invoke(fileScanner);
    }
}
