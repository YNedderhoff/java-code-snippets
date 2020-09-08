package xyz.nedderhoff.springbootbasic.codesnippets.generics;

public class TestClass1 extends AbstractTestClass1<String, TestClass2> {

    public static class InnerTestClass11 extends AbstractInnerTestClass11<String, TestClass2> {
        @Override
        public AbstractTestClass2.AbstractInnerTestClass21<String> generate() {
            return null;
        }
    }

    public static class InnerTestClass12 extends AbstractInnerTestClass12<String, TestClass2> {

        @Override
        public AbstractTestClass2.AbstractInnerTestClass21<String> generate() {
            return null;
        }
    }
}
