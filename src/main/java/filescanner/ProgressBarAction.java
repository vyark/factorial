package filescanner;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RecursiveAction;

public class ProgressBarAction extends RecursiveAction {
    private Logger logger;

    public ProgressBarAction(Logger logger) {
        this.logger = logger;
    }

    @SneakyThrows(InterruptedException.class)
    @Override
    protected void compute() {
        char[] animationChars = new char[]{'|', '/', '-', '\\'};

        for (int i = 0; i <= 100; i++) {
            logger.info("Processing: " + i + "% " + animationChars[i % 4] + "\r");

            Thread.sleep(200);
        }

        logger.info("Processing: Done!");
    }
}
