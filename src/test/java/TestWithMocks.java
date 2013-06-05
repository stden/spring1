//Let's import Mockito statically so that the code looks clearer

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Тест с использованием Mockito
 */
public class TestWithMocks {
    // Let's verify some behaviour!
    @Test
    public void mock1() {
        //mock creation
        List mockedList = mock(List.class);
        //using mock object
        mockedList.add("one");
        mockedList.clear();
        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
