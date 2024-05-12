package org.lab3.common;

import org.lab3.addMethods.AddFirstToList;
import org.lab3.addMethods.AddLastToList;
import org.lab3.addMethods.AddMiddleToList;
import org.lab3.addMethods.AddToCollection;
import org.lab3.getMethods.GetFirstElementList;
import org.lab3.getMethods.GetLastElementList;
import org.lab3.getMethods.GetMiddleElementList;
import org.lab3.otherMethods.ClearCollection;
import org.lab3.removeMethods.RemoveFirstFromList;
import org.lab3.removeMethods.RemoveFromCollection;
import org.lab3.removeMethods.RemoveLastFromList;
import org.lab3.removeMethods.RemoveMiddleFromList;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Performance comparison of ArrayList and LinkedList.
 */
public class Main {
    /**
     * Number of tests.
     */
    static int numTests = 5;
    /**
     * Output formatting.
     */
    static String format = "|%-25s|%-8s|%-11s|%-8s|%n";
    /**
     * Generator of elements for methods.
     */
    public static IGenerateElement<Integer> generateElementInteger = () -> 0;
    /**
     * Generator of elements for methods.
     */
    public static IGenerateElement<String> generateElementString = () -> "A";

    /**
     * Measuring of Collection method Add
     */
    public static void testAddCollection(){
        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                LinkedList<Integer> linkedList = new LinkedList<>();
                CollectionMethodPerformanceMeasure<Integer> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new AddToCollection<>(arrayList, generateElementInteger));
                CollectionMethodPerformanceMeasure<Integer> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new AddToCollection<>(linkedList, generateElementInteger));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Add Collection", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Add Collection", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }

    /**
     * Measuring of List method Add First
     */
    public static void testAddFirstToList(){
        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                LinkedList<Integer> linkedList = new LinkedList<>();
                CollectionMethodPerformanceMeasure<Integer> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new AddFirstToList<>(arrayList, generateElementInteger));
                CollectionMethodPerformanceMeasure<Integer> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new AddFirstToList<>(linkedList, generateElementInteger));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Add First to List", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Add First to List", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }
    /**
     * Measuring of List method Add Last
     */
    public static void testAddLastToList(){
        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                LinkedList<Integer> linkedList = new LinkedList<>();
                CollectionMethodPerformanceMeasure<Integer> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new AddLastToList<>(arrayList, generateElementInteger));
                CollectionMethodPerformanceMeasure<Integer> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new AddLastToList<>(linkedList, generateElementInteger));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Add Last to List", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Add Last to List", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }
    /**
     * Measuring of List method Add Middle
     */
    public static void testAddMiddleToList(){
        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                LinkedList<Integer> linkedList = new LinkedList<>();
                CollectionMethodPerformanceMeasure<Integer> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new AddMiddleToList<>(arrayList, generateElementInteger));
                CollectionMethodPerformanceMeasure<Integer> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new AddMiddleToList<>(linkedList, generateElementInteger));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Add Middle to List", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Add Middle to List", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }
    /**
     * Measuring of Collection method Remove
     */
    public static void testRemoveCollection(){
        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<String> arrayList = new ArrayList<>();

                LinkedList<String> linkedList = new LinkedList<>();
                for (int i =0; i<numOperation; i++){
                    arrayList.add("A");
                    linkedList.add("A");
                }
                CollectionMethodPerformanceMeasure<String> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new RemoveFromCollection<>(arrayList, generateElementString));
                CollectionMethodPerformanceMeasure<String> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new RemoveFromCollection<>(linkedList, generateElementString));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Remove from collection", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Remove from collection", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }
    /**
     * Measuring of List method Remove First
     */
    public static void testRemoveFirst(){
        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<String> arrayList = new ArrayList<>();

                LinkedList<String> linkedList = new LinkedList<>();
                for (int i =0; i<numOperation; i++){
                    arrayList.add("A");
                    linkedList.add("A");
                }
                CollectionMethodPerformanceMeasure<String> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new RemoveFirstFromList<>(arrayList, generateElementString));
                CollectionMethodPerformanceMeasure<String> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new RemoveFirstFromList<>(linkedList, generateElementString));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Remove First From List", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Remove First From List", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }
    /**
     * Measuring of List method Remove Last
     */
    public static void testRemoveLast(){
        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<String> arrayList = new ArrayList<>();

                LinkedList<String> linkedList = new LinkedList<>();
                for (int i =0; i<numOperation; i++){
                    arrayList.add("A");
                    linkedList.add("A");
                }
                CollectionMethodPerformanceMeasure<String> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new RemoveLastFromList<>(arrayList, generateElementString));
                CollectionMethodPerformanceMeasure<String> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new RemoveLastFromList<>(linkedList, generateElementString));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Remove Last From List", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Remove Last From List", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }
    /**
     * Measuring of List method Remove Middle
     */
    public static void testRemoveMiddle(){
        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<String> arrayList = new ArrayList<>();

                LinkedList<String> linkedList = new LinkedList<>();
                for (int i =0; i<numOperation; i++){
                    arrayList.add("A");
                    linkedList.add("A");
                }
                CollectionMethodPerformanceMeasure<String> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new RemoveMiddleFromList<>(arrayList, generateElementString));
                CollectionMethodPerformanceMeasure<String> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new RemoveMiddleFromList<>(linkedList, generateElementString));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Remove Middle From List", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Remove Middle From List", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }

    /**
     * Measuring of List method Get First
     */
    static void testGetFirst(){
        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<String> arrayList = new ArrayList<>();

                LinkedList<String> linkedList = new LinkedList<>();
                for (int i =0; i<5; i++){
                    arrayList.add("A");
                    linkedList.add("A");
                }
                CollectionMethodPerformanceMeasure<String> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new GetFirstElementList<>(arrayList, generateElementString));
                CollectionMethodPerformanceMeasure<String> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new GetFirstElementList<>(linkedList, generateElementString));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Get First From List", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Get First From List", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }
    /**
     * Measuring of List method Get Last
     */
    static void testGetLast(){
            for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
                double arrayAvg = 0;
                double linkedAvg = 0;
                for (int numTest = 0; numTest < numTests; numTest++) {
                    ArrayList<String> arrayList = new ArrayList<>();

                    LinkedList<String> linkedList = new LinkedList<>();
                    for (int i =0; i<5; i++){
                        arrayList.add("A");
                        linkedList.add("A");
                    }
                    CollectionMethodPerformanceMeasure<String> testAddArray =
                            new CollectionMethodPerformanceMeasure<>(numOperation,
                                    new GetLastElementList<>(arrayList, generateElementString));
                    CollectionMethodPerformanceMeasure<String> testAddLinked =
                            new CollectionMethodPerformanceMeasure<>(numOperation,
                                    new GetLastElementList<>(linkedList, generateElementString));
                    testAddArray.testCollectionMethod();
                    testAddLinked.testCollectionMethod();
                    arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                    linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
                }
                System.out.printf(format, "Get Last From List", numOperation/1000+"k", "Array List", arrayAvg/numTests);
                System.out.printf(format, "Get Last From List", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
            }
        }
    /**
     * Measuring of List method Get Middle
     */
    static void testGetMiddle(){
        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<String> arrayList = new ArrayList<>();

                LinkedList<String> linkedList = new LinkedList<>();
                for (int i =0; i<5; i++){
                    arrayList.add("A");
                    linkedList.add("A");
                }
                CollectionMethodPerformanceMeasure<String> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new GetMiddleElementList<>(arrayList, generateElementString));
                CollectionMethodPerformanceMeasure<String> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new GetMiddleElementList<>(linkedList, generateElementString));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Get Last From List", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Get Last From List", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }
    /**
     * Measuring of Collection method Clear
     */
    static void testClear(){

        for(int numOperation=50000; numOperation<=1000000; numOperation*=5){
            double arrayAvg = 0;
            double linkedAvg = 0;
            for (int numTest = 0; numTest < numTests; numTest++) {
                ArrayList<String> arrayList = new ArrayList<>();

                LinkedList<String> linkedList = new LinkedList<>();
                for (int i =0; i<5; i++){
                    arrayList.add("A");
                    linkedList.add("A");
                }
                CollectionMethodPerformanceMeasure<String> testAddArray =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new ClearCollection<>(arrayList));
                CollectionMethodPerformanceMeasure<String> testAddLinked =
                        new CollectionMethodPerformanceMeasure<>(numOperation,
                                new ClearCollection<>(linkedList));
                testAddArray.testCollectionMethod();
                testAddLinked.testCollectionMethod();
                arrayAvg+=Duration.ofNanos(testAddArray.getResult()).toMillis();
                linkedAvg+=Duration.ofNanos(testAddLinked.getResult()).toMillis();
            }
            System.out.printf(format, "Clear Collection", numOperation/1000+"k", "Array List", arrayAvg/numTests);
            System.out.printf(format, "Clear Collection", numOperation/1000+"k", "Linked List", linkedAvg/numTests);
        }
    }
    /**
     * Main method to initiate performance tests.
     *
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args) {

        System.out.printf(format, "OP.NAME", "OP.COUNT", "COLLECTION", "TIME(ms)");
        testAddCollection();
        testAddFirstToList();
        testAddLastToList();
        testAddMiddleToList();
        testRemoveCollection();
        testRemoveFirst();
        testRemoveLast();
        testRemoveMiddle();
        testGetFirst();
        testGetLast();
        testGetMiddle();
        testClear();


    }
}
