package org.lab5;
/**
 * Another implementation of the SomeOtherInterface interface.
 */
public class OtherImpl implements SomeOtherInterface {
    /**
     * {@inheritDoc}
     */
    @Override
    public void doSomeOther() {
        System.out.println("B");
    }
}
