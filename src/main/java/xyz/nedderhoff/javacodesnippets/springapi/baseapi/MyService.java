package xyz.nedderhoff.javacodesnippets.springapi.baseapi;

import java.net.SocketTimeoutException;
import java.util.Optional;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private static final Logger logger = LoggerFactory.getLogger(MyService.class);
    private final Client client;

    @Autowired
    public MyService(Client client) {
        this.client = client;
    }

    public Optional<String> get() {
        String requestUrl = "http://35.195.231.72:8080/temperature/last";
        try {
            return Optional.of(client.target(requestUrl)
                    .request(MediaType.APPLICATION_JSON)
                    .get(String.class));
        } catch (ProcessingException e) {
            logger.error("Exception occured");
            if (e.getCause() instanceof SocketTimeoutException) {
                if (e.getCause().getMessage().toLowerCase().equals("connect timed out")) {
                    logger.info("Connect timeout detected");
                } else if (e.getCause().getMessage().toLowerCase().equals("read timed out")) {
                    logger.info("Request timeout detected");
                } else {
                    logger.info("no idea: {}", e.getCause().getMessage());
                }
            }
            return Optional.empty();
        }
    }
}
