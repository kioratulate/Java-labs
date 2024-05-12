package org.lab5;
/**
 * An implementation of the SomeOtherInterface interface.
 */
public class SODoer implements SomeOtherInterface {
    /**
     * {@inheritDoc}
     */
    @Override
    public void doSomeOther() {
        System.out.println("C");
    }
}
