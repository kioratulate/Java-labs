package org.lab3;

import java.time.Duration;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//    CollectionMethodPerformanceTester<Integer> testerAdd =
//            new CollectionMethodPerformanceTester<>(100000000, new TestAddArrayList<>(
//                    args1 -> {return (int)(Math.random()*1000);}));
    double avg_soft =0;
    double avg_hard =0;
    for (int i = 0; i<5; ++i)
    {
    System.out.println("--softcode--"+i);
    CollectionMethodPerformanceTester<Integer> testerAdd =
                new CollectionMethodPerformanceTester<>(500000000, new TestAddArrayList<>(
                        args1 -> {return 0;}));
    testerAdd.testCollectionMethod();
    System.out.println(Duration.ofNanos(testerAdd.getResult()).toMillis());
    avg_soft+=Duration.ofNanos(testerAdd.getResult()).toMillis();
    System.out.println("--hardcode--"+i);
    ArrayList<Integer> arrayList = new ArrayList<>();
    long time = 0;
    for (int j = 0; j<500000000;j++){
        long start = System.nanoTime();
        arrayList.add(0);
        time +=(System.nanoTime()-start);
    }
    System.out.println(Duration.ofNanos(time).toMillis());
    avg_hard+=Duration.ofNanos(time).toMillis();
    }
    System.out.println("soft:" + avg_soft/5 + "\nhard:"+ avg_hard/5);
    }
}
