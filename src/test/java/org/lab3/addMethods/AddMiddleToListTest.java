package org.lab3.addMethods;

import org.junit.jupiter.api.Test;
import org.lab3.common.CollectionMethodPerformanceMeasure;
import org.lab3.common.IGenerateElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AddMiddleToListTest {

    int numOperations = 10000;
    int numTests = 5;
    double accept_rate = 0.5;
    @Test
    void addMiddleToArrayList() {
        double avgComplicated =0;
        double avgStraightforward =0;
        for (int i = 0; i<numTests; ++i)
        {
            //create instance of tester with AddMiddleToList
            
            ArrayList<String> arrayList = new ArrayList<>();
            CollectionMethodPerformanceMeasure<String> testAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new AddMiddleToList<>(arrayList, () -> "hello"));

            testAdd.testCollectionMethod();
            System.out.println(Duration.ofNanos(testAdd.getResult()).toMillis());
            avgComplicated+=Duration.ofNanos(testAdd.getResult()).toMillis();
            
            arrayList = new ArrayList<>();
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                int ind = arrayList.size()/2;
                long start = System.nanoTime();
                arrayList.add(ind, "hello");
                time +=(System.nanoTime()-start);
            }
            avgStraightforward+=Duration.ofNanos(time).toMillis();
            
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }

    @Test
    void addMiddleToLinkedList() {
        double avgComplicated =0;
        double avgStraightforward =0;
        for (int i = 0; i<numTests; ++i)
        {
            //create instance of tester with AddMiddleToList
            
            LinkedList<String> linkedList = new LinkedList<>();
            CollectionMethodPerformanceMeasure<String> testAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new AddMiddleToList<LinkedList<String>, String>(linkedList, () -> "hello"));

            testAdd.testCollectionMethod();
            System.out.println(Duration.ofNanos(testAdd.getResult()).toMillis());
            avgComplicated+=Duration.ofNanos(testAdd.getResult()).toMillis();
            
            linkedList = new LinkedList<>();
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                int ind = linkedList.size()/2;
                long start = System.nanoTime();
                linkedList.add(ind,"hello");
                time +=(System.nanoTime()-start);
            }
            avgStraightforward+=Duration.ofNanos(time).toMillis();
            
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }

}