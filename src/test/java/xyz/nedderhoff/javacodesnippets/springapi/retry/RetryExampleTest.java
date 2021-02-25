package xyz.nedderhoff.javacodesnippets.springapi.retry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;

@ExtendWith(MockitoExtension.class)
class RetryExampleTest {

    @Mock
    private RetryTemplate retryTemplate;

    @InjectMocks
    private RetryExample retryExample;

    @Test
    void testRetryTemplate1() throws Throwable {
        String expected = "test";
        when(retryTemplate.execute(any(), any(), any())).thenReturn(expected);
        String result = retryExample.testRetries();
        assertEquals(expected, result);
    }

    @Test
    void testRetryTemplate2() throws Throwable {
        String expected = "test";
        RetryContext retryContext = mock(RetryContext.class);
        when(retryTemplate.execute(any(), any(), any())).thenAnswer(
                invocationOnMock -> {
                    RetryCallback<String, RuntimeException> argument = invocationOnMock.getArgument(0);
                    return argument.doWithRetry(retryContext);
                }
        );
        String result = retryExample.testRetries();
        assertEquals(expected, result);
    }
}