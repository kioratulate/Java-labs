package org.lab3.addMethods;

import org.junit.jupiter.api.Test;
import org.lab3.common.CollectionMethodPerformanceMeasure;
import org.lab3.common.IGenerateElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AddAllToCollectionTest {
    int numTests = 30;
    int numOperations = 500000;
    double accept_rate = 0.5;
    @Test
    void addAllToArrayList(){
        double avgComplicated =0;
        double avgStraightforward =0;

        for (int i = 0; i<numTests; ++i)
        {
            ArrayList<Integer> arrayList = new ArrayList<>();
            CollectionMethodPerformanceMeasure<ArrayList<Integer>> testerAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new AddAllToCollection<>(arrayList, () -> {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add((int)(Math.random()*10));
                        return list;
                    }));
            testerAdd.testCollectionMethod();
            avgComplicated+=Duration.ofNanos(testerAdd.getResult()).toMillis();
            
            arrayList = new ArrayList<>();
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                ArrayList<Integer> list = new ArrayList<>();
                list.add((int)(Math.random()*10));
                long start = System.nanoTime();
                arrayList.addAll(list);
                time +=(System.nanoTime()-start);
            }
            avgStraightforward+=Duration.ofNanos(time).toMillis();
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }
    @Test
    void addAllToLinkedList(){
        double avgComplicated =0;
        double avgStraightforward =0;
        for (int i = 0; i<numTests; ++i)
        {
            
            LinkedList<Integer> linkedList = new LinkedList<>();
            CollectionMethodPerformanceMeasure<ArrayList<Integer>> testerAdd =
                    new CollectionMethodPerformanceMeasure<>(numOperations, new AddAllToCollection<>(linkedList, () -> {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add((int)(Math.random()*10));
                        return list;
                    }));
            testerAdd.testCollectionMethod();

            avgComplicated+=Duration.ofNanos(testerAdd.getResult()).toMillis();

            linkedList = new LinkedList<>();
            long time = 0;
            for (int j = 0; j<numOperations;j++){
                ArrayList<Integer> list = new ArrayList<>();
                list.add((int)(Math.random()*10));
                long start = System.nanoTime();
                linkedList.addAll(list);
                time +=(System.nanoTime()-start);
            }
            
            avgStraightforward+=Duration.ofNanos(time).toMillis();
        }
        avgComplicated/=numTests;
        avgStraightforward/=numTests;
        assertTrue(avgComplicated-avgStraightforward <= avgStraightforward*accept_rate);
    }

}