package org.lab3.addMethods;

import org.junit.jupiter.api.Test;
import org.lab3.common.CollectionMethodPerformanceMeasure;
import org.lab3.common.IGenerateElement;


import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AddToCollectionTest {
    int numOperations = 500000;
    int numTests = 20;
    double accept_rate = 0.5;
    /**Test add to ArrayList and make sure that our complicated structure of methods
     * and measurement didn't really affect the performance, or didn't affect to a certain point
     */
    @Test
    void addToArrayList() {
        double avgComplicated =0;
        double avgStraightforward =0;

        for (int i = 0; i<numTests; ++i)
        {
            
            ArrayList<Integer> arrayList = new ArrayList<>();
            CollectionMethodPerformanceMeasure<Integer> testerAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new AddToCollection<>(arrayList, () -> (int)(Math.random()*10)));
            testerAdd.testCollectionMethod();
            
            avgComplicated+=Duration.ofNanos(testerAdd.getResult()).toMillis();
            
            arrayList = new ArrayList<>();
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                int elem = (int)(Math.random()*10);
                long start = System.nanoTime();
                arrayList.add(elem);
                time +=(System.nanoTime()-start);
            }
            
            avgStraightforward+=Duration.ofNanos(time).toMillis();
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }

    /**Test add to LinkedList and make sure that our complicated structure of methods
     * and measurement didn't really affect the performance, or didn't affect to a certain point
     */
    @Test
    void addToLinkedList() {
        double avgComplicated =0;
        double avgStraightforward =0;
        for (int i = 0; i<numTests; ++i)
        {
            
            LinkedList<Integer> linkedList = new LinkedList<>();
            CollectionMethodPerformanceMeasure<Integer> testerAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new AddToCollection<>(linkedList, () -> (int)(Math.random()*10)));
            testerAdd.testCollectionMethod();
            
            avgComplicated+=Duration.ofNanos(testerAdd.getResult()).toMillis();
            
            linkedList = new LinkedList<>();
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                int elem = (int)(Math.random()*10);
                long start = System.nanoTime();
                linkedList.add(elem);
                time +=(System.nanoTime()-start);
            }
            
            avgStraightforward+=Duration.ofNanos(time).toMillis();
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }
}