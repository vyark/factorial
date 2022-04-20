package filescanner;

import org.apache.tools.ant.DirectoryScanner;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SizeActionTest {

    private Logger loggerMock = mock(Logger.class);
    private DirectoryScanner directoryScanner = new DirectoryScanner();
    private SizeAction sizeAction = new SizeAction(directoryScanner, loggerMock);

    @Test
    public void testSizeAction() {
        directoryScanner.scan();
        sizeAction.compute();

        verify(loggerMock).info("Files size: 0");
    }
}
