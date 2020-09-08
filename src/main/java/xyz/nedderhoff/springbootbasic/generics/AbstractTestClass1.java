package xyz.nedderhoff.springbootbasic.generics;

public abstract class AbstractTestClass1<TypeParam, A extends AbstractTestClass2<TypeParam>> {
    public static abstract class AbstractInnerTestClass11<TypeParam, T extends AbstractTestClass2<TypeParam>> {
        public abstract AbstractTestClass2.AbstractInnerTestClass21<TypeParam> generate();
    }

    public static abstract class AbstractInnerTestClass12<TypeParam, T extends AbstractTestClass2<TypeParam>> extends AbstractInnerTestClass11<TypeParam, T>{

    }
}
