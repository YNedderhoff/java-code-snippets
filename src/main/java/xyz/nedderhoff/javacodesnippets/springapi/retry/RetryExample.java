package xyz.nedderhoff.javacodesnippets.springapi.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class RetryExample {

    private final RetryTemplate retryTemplate;

    @Autowired
    public RetryExample(RetryTemplate retryTemplate) {
        this.retryTemplate = retryTemplate;
    }

    public String testRetries() {
        return retryTemplate.execute(
                new RetryCallback<String, RuntimeException>() {
                    @Override
                    public String doWithRetry(RetryContext context) {
                        return "test";
                    }
                }
        );
    }
}
