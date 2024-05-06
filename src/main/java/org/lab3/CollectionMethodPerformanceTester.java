package org.lab3;

/**
 * An instrument to test perfomance of given function, relies on interface TestMethod, which provides needed entities to test
 * @param <T> type of content of collection
 */
public class CollectionMethodPerformanceTester<T> {
    /**
     * Number of operation to measure
     */
    private final long numOperations;
    /**
     * Measured summarised time of numOperations operations tested in nanos
     */
    private long time;
    /**
     * Entity to test
     */
    private final TestMethod<T> testMethod;

    /**
     * Creates tester for concrete operation
     * @param numOperations number of operations to test
     * @param testMethod entity that provides method to test
     */
    public CollectionMethodPerformanceTester(long numOperations, TestMethod<T> testMethod) {
        this.numOperations = numOperations;
        this.testMethod = testMethod;
        time = 0;
    }

    /**
     * Testing of given method:
     * measuring time of only given method
     */
    public void testCollectionMethod(){
        for (int i = 0; i < numOperations; i++) {
            T elem = testMethod.getContent();

            long start = System.nanoTime();
            testMethod.apply(elem);
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
