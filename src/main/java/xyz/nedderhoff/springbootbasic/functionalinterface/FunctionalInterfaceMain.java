package xyz.nedderhoff.springbootbasic.functionalinterface;

public class FunctionalInterfaceMain {
    public static void main(String[] args) {
        new FunctionalInterfaceUsingClass(FunctionalInterfaceClassImplementer1::new);
        new FunctionalInterfaceUsingClass(FunctionalInterfaceClassImplementer2::new);
    }
}
