package filescanner;

import org.apache.tools.ant.DirectoryScanner;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

public class CountActionTest {
    private Logger loggerMock = mock(Logger.class);
    private DirectoryScanner directoryScanner = new DirectoryScanner();
    private CountAction countAction = new CountAction(directoryScanner, loggerMock);

    @Test
    public void testCountAction() {
        directoryScanner.scan();
        countAction.compute();

        verify(loggerMock, times(2)).info("0");
    }
}
