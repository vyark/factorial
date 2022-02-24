package filescanner;

import org.apache.tools.ant.DirectoryScanner;

import java.util.concurrent.RecursiveAction;

public class SizeAction extends RecursiveAction {

    private DirectoryScanner directoryScanner;

    public SizeAction(DirectoryScanner directoryScanner) {
        this.directoryScanner = directoryScanner;
    }

    @Override
    protected void compute() {
        int filesSize = 0;
        for (String fileName : directoryScanner.getIncludedFiles()) {
            filesSize += directoryScanner.getResource(fileName).getSize();
        }

        System.out.println(filesSize);
    }
}
