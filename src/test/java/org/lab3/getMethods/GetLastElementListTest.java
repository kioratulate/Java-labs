package org.lab3.getMethods;

import org.junit.jupiter.api.Test;
import org.lab3.common.CollectionMethodPerformanceMeasure;
import org.lab3.common.IGenerateElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class GetLastElementListTest {
    int numOperations = 1000000;
    int numTests = 50;
    int list_size = 10;
    double accept_rate = 0.5;
    @Test
    void getLastToArrayList() {
        double avgComplicated =0;
        double avgStraightforward =0;
        for (int i = 0; i<numTests; ++i)
        {
            //create instance of tester with AddMiddleToList
            
            ArrayList<String> arrayList = new ArrayList<>();
            for(int j = 0; j<list_size;j++)
                arrayList.add("hello");
            CollectionMethodPerformanceMeasure<String> testAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new GetLastElementList<>(arrayList, () -> null));

            testAdd.testCollectionMethod();
            System.out.println(Duration.ofNanos(testAdd.getResult()).toMillis());
            avgComplicated+=Duration.ofNanos(testAdd.getResult()).toMillis();
            
            arrayList = new ArrayList<>();
            for(int j = 0; j<list_size;j++)
                arrayList.add("hello");
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                long start = System.nanoTime();
                arrayList.getLast();
                time +=(System.nanoTime()-start);
            }
            avgStraightforward+=Duration.ofNanos(time).toMillis();
            
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }

    @Test
    void getLastToLinkedList() {
        double avgComplicated =0;
        double avgStraightforward =0;
        for (int i = 0; i<numTests; ++i)
        {
            //create instance of tester with AddMiddleToList
            
            LinkedList<String> linkedList = new LinkedList<>();
            for(int j = 0; j<list_size;j++)
                linkedList.add("hello");
            CollectionMethodPerformanceMeasure<String> testAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new GetLastElementList<>(linkedList, () -> null));

            testAdd.testCollectionMethod();
            System.out.println(Duration.ofNanos(testAdd.getResult()).toMillis());
            avgComplicated+=Duration.ofNanos(testAdd.getResult()).toMillis();
            
            linkedList = new LinkedList<>();
            for(int j = 0; j<list_size;j++)
                linkedList.add("hello");
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                long start = System.nanoTime();
                String str = linkedList.getLast();
                time +=(System.nanoTime()-start);
            }
            avgStraightforward+=Duration.ofNanos(time).toMillis();
            
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }
}