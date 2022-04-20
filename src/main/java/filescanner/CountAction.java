package filescanner;

import org.apache.tools.ant.DirectoryScanner;
import org.slf4j.Logger;

import java.util.concurrent.RecursiveAction;

public class CountAction extends RecursiveAction {
    private Logger logger;

    private DirectoryScanner directoryScanner;

    public CountAction(DirectoryScanner directoryScanner, Logger logger) {
        this.directoryScanner = directoryScanner;
        this.logger = logger;
    }

    @Override
    protected void compute() {
        logger.info(Integer.toString(directoryScanner.getIncludedFilesCount()));
        logger.info(Integer.toString(directoryScanner.getIncludedDirsCount()));
    }
}
