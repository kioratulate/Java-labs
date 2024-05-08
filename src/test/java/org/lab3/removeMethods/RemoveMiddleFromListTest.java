package org.lab3.removeMethods;

import org.junit.jupiter.api.Test;
import org.lab3.common.CollectionMethodPerformanceMeasure;
import org.lab3.common.IGenerateElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class RemoveMiddleFromListTest {
    int numOperations = 5000;
    int numTests = 50;
    double accept_rate = 0.5;
    @Test
    void removeMiddleToArrayList() {
        double avgComplicated =0;
        double avgStraightforward =0;
        for (int i = 0; i<numTests; ++i)
        {
            //create instance of tester with AddMiddleToList

            ArrayList<String> arrayList = new ArrayList<>(numOperations);
            for(int j = 0; j<numOperations;j++)
                arrayList.add("hello");
            
            CollectionMethodPerformanceMeasure<String> testAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new RemoveMiddleFromList<>(arrayList, () -> null));

            testAdd.testCollectionMethod();
            System.out.println(Duration.ofNanos(testAdd.getResult()).toMillis());
            avgComplicated+=Duration.ofNanos(testAdd.getResult()).toMillis();

            arrayList = new ArrayList<>(numOperations);
            for(int j = 0; j<numOperations;j++)
                arrayList.add("hello");
            
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                int ind = arrayList.size()/2;
                long start = System.nanoTime();
                arrayList.remove(ind);
                time +=(System.nanoTime()-start);
            }
            avgStraightforward+=Duration.ofNanos(time).toMillis();
            
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }

    @Test
    void removeMiddleToLinkedList() {
        double avgComplicated =0;
        double avgStraightforward =0;
        for (int i = 0; i<numTests; ++i)
        {
            //create instance of tester with AddMiddleToList
            
            LinkedList<String> linkedList = new LinkedList<>();
            for(int j = 0; j<numOperations;j++)
                linkedList.add("hello");
            CollectionMethodPerformanceMeasure<String> testAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new RemoveMiddleFromList<>(linkedList, () -> null));

            testAdd.testCollectionMethod();
            System.out.println(Duration.ofNanos(testAdd.getResult()).toMillis());
            avgComplicated+=Duration.ofNanos(testAdd.getResult()).toMillis();
            
            linkedList = new LinkedList<>();
            for(int j = 0; j<numOperations;j++)
                linkedList.add("hello");
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                int ind = linkedList.size()/2;
                long start = System.nanoTime();
                linkedList.remove(ind);
                time +=(System.nanoTime()-start);
            }
            avgStraightforward+=Duration.ofNanos(time).toMillis();
            
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }

}