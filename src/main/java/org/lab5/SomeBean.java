package org.lab5;
/**
 * A class demonstrating the usage of the AutoInjectable annotation.
 */
public class SomeBean {
    /**
     * An instance of SomeInterface, automatically injected by the Injector class.
     */
    @AutoInjectable
    private SomeInterface field1;
    /**
     * An instance of SomeOtherInterface, automatically injected by the Injector class.
     */
    @AutoInjectable
    private SomeOtherInterface field2;
    /**
     * Performs some operations using the injected dependencies.
     */
    public void foo(){
        field1.doSomething();
        field2.doSomeOther();
    }
}
