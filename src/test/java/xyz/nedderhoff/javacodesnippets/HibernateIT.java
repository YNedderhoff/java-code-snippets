package xyz.nedderhoff.javacodesnippets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

import xyz.nedderhoff.javacodesnippets.springapi.Application;
import xyz.nedderhoff.javacodesnippets.util.JsonReader;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
public class HibernateIT {

    private final JsonReader jsonReader = new JsonReader();

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url;

    @BeforeEach
    void beforeEach() {
        this.url = "http://localhost:" + port + "/hibernate/";
    }

    @Test
    public void testHibernateMappingTable() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> authorPost = new HttpEntity<>(jsonReader.read("requests/authorsPost.json"), headers);
        this.restTemplate.postForObject(url + "authors", authorPost, String.class);

        HttpEntity<String> bookPost = new HttpEntity<>(jsonReader.read("requests/booksPost.json"), headers);
        this.restTemplate.postForObject(url + "books", bookPost, String.class);

        HttpEntity<String> authorBookPost = new HttpEntity<>(jsonReader.read("requests/authorBookPost.json"), headers);
        this.restTemplate.postForObject(url + "authorbooks", authorBookPost, String.class);

        String authorsResponse = this.restTemplate.getForObject(url + "authors", String.class);
        assertEquals(jsonReader.read("responses/authorsResponse.json"), authorsResponse);
        String booksResponse = this.restTemplate.getForObject(url + "books", String.class);
        assertEquals(jsonReader.read("responses/booksResponse.json"), booksResponse);
    }
}
