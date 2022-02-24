package filescanner;

import org.apache.tools.ant.DirectoryScanner;

import java.util.concurrent.RecursiveAction;

public class CountAction extends RecursiveAction {

    private DirectoryScanner directoryScanner;

    public CountAction(DirectoryScanner directoryScanner) {
        this.directoryScanner = directoryScanner;
    }

    @Override
    protected void compute() {
        System.out.println(directoryScanner.getIncludedFilesCount());
        System.out.println(directoryScanner.getIncludedDirsCount());
    }
}
