package org.lab3.removeMethods;

import org.junit.jupiter.api.Test;
import org.lab3.common.CollectionMethodPerformanceMeasure;
import org.lab3.common.IGenerateElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RemoveFromCollectionTest {

    int numOperations = 100000;
    int numTests = 20;
    double accept_rate = 0.5;
    @Test
    void removeByObjectFromArrayList() {
        double avgComplicated =0;
        double avgStraightforward =0;
        for (int i = 0; i<numTests; ++i)
        {
            
            ArrayList<String> arrayList = new ArrayList<>(numOperations);
            for (int j = 0; j<numOperations; j++)
            {
                arrayList.add("A");
            }
            CollectionMethodPerformanceMeasure<String> testerAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new RemoveFromCollection<>(arrayList, () -> "A"));
            testerAdd.testCollectionMethod();
            
            avgComplicated+=Duration.ofNanos(testerAdd.getResult()).toMillis();
            
            arrayList = new ArrayList<>(numOperations);
            for (int j = 0; j<numOperations; j++)
            {
                arrayList.add("A");
            }
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                long start = System.nanoTime();
                arrayList.remove("A");
                time +=(System.nanoTime()-start);
            }
            
            avgStraightforward+=Duration.ofNanos(time).toMillis();
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }
    @Test
    void removeByObjectFromLinkedList() {
        double avgComplicated =0;
        double avgStraightforward =0;
        for (int i = 0; i<numTests; ++i)
        {
            
            LinkedList<String> linkedList = new LinkedList<>();
            for (int j = 0; j<numOperations; j++)
            {
                linkedList.add("A");
            }
            CollectionMethodPerformanceMeasure<String> testerAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new RemoveFromCollection<>(linkedList, () -> "A"));
            testerAdd.testCollectionMethod();
            
            avgComplicated+=Duration.ofNanos(testerAdd.getResult()).toMillis();
            
            linkedList = new LinkedList<>();
            for (int j = 0; j<numOperations; j++)
            {
                linkedList.add("A");
            }
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                long start = System.nanoTime();
                linkedList.remove("A");
                time +=(System.nanoTime()-start);
            }
            
            avgStraightforward+=Duration.ofNanos(time).toMillis();
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }
}