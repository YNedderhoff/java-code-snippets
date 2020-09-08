package xyz.nedderhoff.springbootbasic.codesnippets.functionalinterface;

public  class FunctionalInterfaceClassImplementer2 extends FunctionalInterfaceClass{

    String text;
    public FunctionalInterfaceClassImplementer2(String eins, String zwei) {
        text = "Hallo1: " + eins + " " + zwei;
    }

    @Override
    String test() {
        return text;
    }
}
