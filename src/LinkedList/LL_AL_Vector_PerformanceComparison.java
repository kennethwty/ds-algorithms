package LinkedList;

import java.util.ArrayList;
import java.util.Vector;
import java.util.LinkedList;

public class LL_AL_Vector_PerformanceComparison {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        Vector vector = new Vector();

        /* add() operation in ArrayList */
        long startTime = System.nanoTime();

        for (int i = 0; i < 300000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ArrayList add:  " + duration);

        /* add() operation in LinkedList */
        startTime = System.nanoTime();

        for (int i = 0; i < 300000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList add: " + duration);

        /* add() operation in Vector */
        startTime = System.nanoTime();

        for (int i = 0; i < 300000; i++) {
            vector.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Vector add: " + duration);

        System.out.println();

        /* get() operation in ArrayList */
        startTime = System.nanoTime();

        for (int i = 0; i < 30000; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList get:  " + duration);

        /* get() operation in LinkedList */
        startTime = System.nanoTime();

        for (int i = 0; i < 30000; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList get: " + duration);

        /* get() operation in Vector */
        startTime = System.nanoTime();

        for (int i = 0; i < 30000; i++) {
            vector.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Vector get: " + duration);

        System.out.println();

        /* remove() operation in ArrayList */
        startTime = System.nanoTime();

        for (int i = 5000; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList remove:  " + duration);

        /* remove() operation in LinkedList */
        startTime = System.nanoTime();

        for (int i = 5000; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList remove: " + duration);

        /* remove() operation in Vector */
        startTime = System.nanoTime();

        for (int i = 5000; i >= 0; i--) {
            vector.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Vector remove: " + duration);
    }
}