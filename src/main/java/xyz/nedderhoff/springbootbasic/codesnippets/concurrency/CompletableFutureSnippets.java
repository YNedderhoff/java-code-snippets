package xyz.nedderhoff.springbootbasic.codesnippets.concurrency;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureSnippets {

    public static void main(String[] args) {
        Runnable test = new Runnable() {
            @Override
            public void run() {
                runThisShit("test");
            }

            public void runThisShit(String thisIsAParam){
                System.out.println("It works! " + thisIsAParam);
            }
        };
        CompletableFuture
                .runAsync(test)
                .exceptionally(CompletableFutureSnippets::handle);
    }

    private static void run(String thisIsAParam) {
        System.out.println("It works! " + thisIsAParam);
    }

    private static Void handle(Throwable t) {
        return null;
    }
}
