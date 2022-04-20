package filescanner;

import org.apache.tools.ant.DirectoryScanner;
import org.slf4j.Logger;

import java.util.concurrent.RecursiveAction;

public class SizeAction extends RecursiveAction {
    private Logger logger;

    private DirectoryScanner directoryScanner;

    public SizeAction(DirectoryScanner directoryScanner, Logger logger) {
        this.directoryScanner = directoryScanner;
        this.logger = logger;
    }

    @Override
    protected void compute() {
        int filesSize = 0;
        for (String fileName : directoryScanner.getIncludedFiles()) {
            filesSize += directoryScanner.getResource(fileName).getSize();
        }

        logger.info(String.format("Files size: %d", filesSize));
    }
}
