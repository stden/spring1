import example.ExternalService;
import example.InternalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

/**
 * http://habrahabr.ru/post/172239/
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ExternalService.class})
public class InternalServiceTest {
    private final ExternalService externalService = PowerMockito.mock(ExternalService.class);
    private final InternalService internalService = new InternalService(externalService);

    @Before
    public void before() {
        reset(externalService);
    }

    @Test
    public void doWorkTest() {
        internalService.doWork();

        verify(externalService).doMegaWork();
    }
}