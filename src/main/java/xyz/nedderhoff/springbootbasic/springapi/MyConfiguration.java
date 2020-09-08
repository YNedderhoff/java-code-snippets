package xyz.nedderhoff.springbootbasic.springapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
public class MyConfiguration {

    @Bean
    public ExecutorService executorService(@Value("${logodetection.threadPoolSize:64}") int nThreads) {
        return Executors.newFixedThreadPool(nThreads);
    }

    @Bean
    public Client client(@Value("${logodetection.restClient.connectTimeout:3000}") int connectTimeout,
                         @Value("${logodetection.restClient.readTimeout:1}") int readTimeout) {
        ClientConfig config = new ClientConfig()
                .property(ClientProperties.CONNECT_TIMEOUT, connectTimeout)
                .property(ClientProperties.READ_TIMEOUT, readTimeout);
        return ClientBuilder.newClient(config).register(new JacksonJsonProvider());
    }
}
