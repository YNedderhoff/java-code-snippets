package xyz.nedderhoff.javacodesnippets.springapi.smartlifecycle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import javax.ws.rs.BadRequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;

import xyz.nedderhoff.javacodesnippets.springapi.baseapi.MyEnum;
import xyz.nedderhoff.javacodesnippets.springapi.baseapi.PlayComponent;

@Component
public class StartLoop implements SmartLifecycle {

    private static final Logger log = LoggerFactory.getLogger(StartLoop.class);
    private static final int LAST_PHASE = Integer.MAX_VALUE;
    private boolean running;

    @Autowired
    private PlayComponent playComponent;

    private static <T> T filterCompletedExceptionally(CompletableFuture<T> future) {
        try {
            return future.get();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean containAtLeastOneTimeoutException(List<CompletableFuture<Integer>> futureResponses) {
        for (CompletableFuture<Integer> future : futureResponses) {
            try {
                future.get();
            } catch (Exception e) {
                log.info("", e);
            }
        }
        return false;
    }

    @Override
    public void start() {

        log.info("Starting ...");
        CompletableFuture.runAsync(this::runMyCode);
        CompletableFuture.runAsync(this::runMyOtherCode)
                .exceptionally(t -> {
                    log.error("T found in start", t);
                    return null;
                });
    }

    private void runMyOtherCode() {
        try {
            log.info("Other code running");
            IllegalArgumentException test = new IllegalArgumentException("test");
            throw new BadRequestException("test", test);
        } catch (IllegalArgumentException e) {
            log.error("IllegalArgument", e);
        } catch (BadRequestException e) {
            log.error("BadRequest", e);
        }
        CompletableFuture.runAsync(this::runMyOtherOtherCode)
                .exceptionally(t -> {
                    log.error("T found in runMyOtherCode", t);
                    return null;
                });

        CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(this::runMyOtherOtherOtherCode);
        CompletableFuture<Integer> integerCompletableFuture2 = CompletableFuture.supplyAsync(() -> 1);
        ImmutableList<CompletableFuture<Integer>> futuresList = ImmutableList.of(integerCompletableFuture1, integerCompletableFuture2);
        boolean b = containAtLeastOneTimeoutException(futuresList);
        futuresList
                .stream()
                .map(StartLoop::filterCompletedExceptionally)
                .filter(Objects::nonNull)
                .forEach(f -> log.info("{}", f));


    }

    private void runMyOtherOtherCode() {
        throw new BadRequestException("yo");
    }

    private Integer runMyOtherOtherOtherCode() {
        throw new BadRequestException("yo2");
    }

    private void runMyCode() {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get("myjson.json")));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enum name " + MyEnum.FIRST.getValue());
        MyEnum.getStringValues()
                .forEach(System.out::println);

        System.out.println(MyEnum.FIRST.getTopic());
        System.out.println(MyEnum.SECOND.getTopic());

        System.out.println(MyEnum.getEnumByString("first").getTopic());

        running = true;
        log.info("Running ...");
        while (running) {
            try {
                Integer result = playComponent.myAwesomeComponentMethod();
                log.info("running, counter is at {}", result);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void stop() {
        log.info("Stopping ...");
    }

    @Override
    public void stop(Runnable callback) {
        callback.run();
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public int getPhase() {
        return LAST_PHASE;
    }

}
