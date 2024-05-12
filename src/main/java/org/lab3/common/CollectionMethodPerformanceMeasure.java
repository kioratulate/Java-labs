package org.lab3.common;


/**
 * An instrument to test the performance of a given method on a collection.
 * @param <T> the type of content in the testing collection
 */
public class CollectionMethodPerformanceMeasure<T> {
    /**
     * Number of operations to measure.
     */
    private long numOperations;
    /**
     * Measured summarized time of numOperations operations tested in nanoseconds.
     */
    private long time;
    /**
     * The method to test.
     */
    private IMethod<T> method;
    /**
     * Changes the testing method (time will be set to 0).
     * @param method the new method to test
     */
    public void setMethod(IMethod<T> method) {
        time = 0;
        this.method = method;
    }
    /**
     * Changes the number of tested operations (time will be set to 0).
     * @param numOperations the new number of operations to test
     */
    public void setNumOperations(long numOperations) {
        time = 0;
        this.numOperations = numOperations;
    }
    /**
     * Creates a tester for a concrete operation.
     * @param numOperations the number of operations to test
     * @param method the entity that provides the method to test
     */
    public CollectionMethodPerformanceMeasure(long numOperations, IMethod<T> method) {
        this.numOperations = numOperations;
        this.method = method;
        time = 0;
    }

    /**
     * Applies the given method and measures the time.
     */
    public void testCollectionMethod(){
        time = 0;
        for (int i = 0; i < numOperations; i++) {
            T elem = method.prepareToApply();

            long start = System.nanoTime();
            method.apply(elem);
            time+=(System.nanoTime()-start);
        }
    }

    /**
     * Returns the measured time. If no tests were performed, returns 0.
     * @return the measured time or 0
     */
    public long getResult() {
        return time;
    }
}
