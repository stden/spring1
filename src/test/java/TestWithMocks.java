//Let's import Mockito statically so that the code looks clearer

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Тест с использованием Mockito
 * http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html#1

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

    // How about some stubbing?
    @Test
    public void mock2() {
        //You can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);
        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException("Super!"));
        //following prints "first"
        System.out.println(mockedList.get(0));
        //following throws runtime exception
        try {
            System.out.println(mockedList.get(1));
            fail();
        } catch (RuntimeException e) {
            assertEquals("Super!", e.getMessage());
        }
        //following prints "null" because get(999) was not stubbed
        assertNull(mockedList.get(999));
        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
        //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }
}
