package xyz.nedderhoff.javacodesnippets.springapi.scheduledtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import xyz.nedderhoff.javacodesnippets.springapi.baseapi.PlayComponent;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final PlayComponent playComponent;

    @Autowired
    public ScheduledTasks(PlayComponent playComponent) {
        this.playComponent = playComponent;
    }

    @PostConstruct
    public void populate() {
        log.info("Hello");
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        Integer result = playComponent.myAwesomeComponentMethod();
        log.info("The time is now {}, PlayComponent counter is at {}", dateFormat.format(new Date()), result);
    }
}