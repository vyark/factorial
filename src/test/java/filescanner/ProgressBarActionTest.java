package filescanner;

import org.apache.tools.ant.DirectoryScanner;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

public class ProgressBarActionTest {
    private Logger loggerMock = mock(Logger.class);
    private ProgressBarAction progressBarAction = new ProgressBarAction(loggerMock);

    @Test
    public void testCountAction() {
        progressBarAction.compute();

        verify(loggerMock, times(102)).info(anyString());
    }
}
