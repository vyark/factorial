package filescanner;

import org.apache.tools.ant.DirectoryScanner;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.RecursiveAction;

public class FileScanner extends RecursiveAction {
    private static final String FILEPATH = "C:\\Users\\Volha_Yarkouskaya";

    @Override
    protected void compute() {
        DirectoryScanner directoryScanner = new DirectoryScanner();
        directoryScanner.setBasedir(new File(FILEPATH));

        directoryScanner.scan();

        CountAction firstSubtask = new CountAction(directoryScanner, LoggerFactory.getLogger(CountAction.class));
        SizeAction secondSubtask = new SizeAction(directoryScanner, LoggerFactory.getLogger(SizeAction.class));
        ProgressBarAction thirdSubtask = new ProgressBarAction(LoggerFactory.getLogger(ProgressBarAction.class));

        firstSubtask.fork();
        thirdSubtask.fork();
        secondSubtask.compute();
        thirdSubtask.quietlyComplete();
        firstSubtask.join();
    }
}
