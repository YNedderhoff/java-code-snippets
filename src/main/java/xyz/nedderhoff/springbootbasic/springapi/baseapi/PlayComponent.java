package xyz.nedderhoff.springbootbasic.springapi.baseapi;

import org.springframework.stereotype.Component;

@Component
public class PlayComponent {
    private Integer counter = 0;

    public Integer myAwesomeComponentMethod() {
        return counter++;
    }
}
