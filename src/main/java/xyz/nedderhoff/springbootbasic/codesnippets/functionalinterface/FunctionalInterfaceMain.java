package xyz.nedderhoff.springbootbasic.codesnippets.functionalinterface;

public class FunctionalInterfaceMain {
    public static void main(String[] args) {
        new FunctionalInterfaceUsingClass(FunctionalInterfaceClassImplementer1::new);
        new FunctionalInterfaceUsingClass(FunctionalInterfaceClassImplementer2::new);
    }
}
