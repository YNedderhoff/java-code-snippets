package xyz.nedderhoff.springbootbasic.codesnippets.functionalinterface;

public class FunctionalInterfaceUsingClass {

    private final FunctionalInterfaceClassConstructor classConstructor;

    public FunctionalInterfaceUsingClass(
            final FunctionalInterfaceClassConstructor classConstructor
    ) {
        this.classConstructor = classConstructor;
    }

    @FunctionalInterface
    public interface FunctionalInterfaceClassConstructor {
        FunctionalInterfaceClass construct(
                String eins,
                String zwei
        );
    }
}
