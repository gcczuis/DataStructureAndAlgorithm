package dataStructure.linkedlist;


import dataStructure.queue.ArrayQueue;
import dataStructure.queue.LoopQueue;
import dataStructure.queue.Queue;

import java.util.Random;

/**
 * 测试arrayqueue和loopqueue的性能差异
 *
 * opCount = 200000时
 * ArrayQueue, time: 15.128604839s
 * LoopQueue, time: 0.018504691s
 * linkedListQueue, time: 0.012759309s
 */
public class TestrrayqueueAndLoopQueueAndLinkedListQueue {

    public static void main(String[] args){
        int opCount = 200000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + "s");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + "s");
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("linkedListQueue, time: " + time3 + "s");
    }

    private static double testQueue(Queue<Integer> q,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;

    }
}