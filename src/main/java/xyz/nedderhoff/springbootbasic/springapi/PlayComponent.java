package xyz.nedderhoff.springbootbasic.springapi;

import org.springframework.stereotype.Component;

@Component
public class PlayComponent {
    private Integer counter = 0;

    public Integer myAwesomeComponentMethod() {
        return counter++;
    }
}
