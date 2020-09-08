package xyz.nedderhoff.springbootbasic.functionalinterface;

public  class FunctionalInterfaceClassImplementer1 extends FunctionalInterfaceClass{

    String text;
    public FunctionalInterfaceClassImplementer1(String eins, String zwei) {
        text = "Hallo1: " + eins + " " + zwei;
    }

    @Override
    String test() {
        return text;
    }
}
