package filescanner;

import org.apache.tools.ant.DirectoryScanner;

import java.io.File;
import java.util.concurrent.RecursiveAction;

public class FileScanner extends RecursiveAction {

    @Override
    protected void compute() {
        DirectoryScanner directoryScanner = new DirectoryScanner();
        directoryScanner.setBasedir(new File("C:\\Users\\Volha_Yarkouskaya"));

        directoryScanner.scan();

        CountAction firstSubtask = new CountAction(directoryScanner);
        SizeAction secondSubtask = new SizeAction(directoryScanner);
        ProgressBarAction thirdSubtask = new ProgressBarAction();

        firstSubtask.fork();
        thirdSubtask.fork();
        secondSubtask.compute();
        thirdSubtask.quietlyComplete();
        firstSubtask.join();
    }
}
