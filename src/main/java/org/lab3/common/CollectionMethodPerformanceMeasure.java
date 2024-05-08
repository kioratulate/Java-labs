package org.lab3.common;


/**
 * An instrument to test performance of given method
 * @param <T> type of content in testing collection
 */
public class CollectionMethodPerformanceMeasure<T> {
    /**
     * Number of operation to measure
     */
    private long numOperations;
    /**
     * Measured summarised time of numOperations operations tested in nanos
     */
    private long time;
    /**
     * IMethod to test
     */
    private IMethod<T> method;
    /**
     * Change testing method(time will be set to 0)
     * @param method new method
     */
    public void setMethod(IMethod<T> method) {
        time = 0;
        this.method = method;
    }
    /**
     * Change number of tested operations (time will be set to 0)
     * @param numOperations new number of operations
     */
    public void setNumOperations(long numOperations) {
        time = 0;
        this.numOperations = numOperations;
    }
    /**
     * Creates tester for concrete operation
     * @param numOperations number of operations to test
     * @param method entity that provides method to test
     */
    public CollectionMethodPerformanceMeasure(long numOperations, IMethod<T> method) {
        this.numOperations = numOperations;
        this.method = method;
        time = 0;
    }

    /**
     * Applying given method and measuring time
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
     * Return measured time, if no tested were performed returns 0
     * @return measured time or 0
     */
    public long getResult() {
        return time;
    }
}
