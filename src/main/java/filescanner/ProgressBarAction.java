package filescanner;

import java.util.concurrent.RecursiveAction;

public class ProgressBarAction extends RecursiveAction {
    @Override
    protected void compute() {
        char[] animationChars = new char[]{'|', '/', '-', '\\'};

        for (int i = 0; i <= 100; i++) {
            System.out.print("Processing: " + i + "% " + animationChars[i % 4] + "\r");

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Processing: Done!");
    }
}
