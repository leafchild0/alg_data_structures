package com.leafchild.structures;

import java.util.Arrays;

/**
 * Custom Queue implementation
 * Implements FIFO set of rules
 * Uses array of Strings to store data
 * Has main method for tests
 * @author: vmalyshev
 * Created: 8/12/16
 */
public class Queue {

    private static String[] theQueue;
    private int queueSize;
    private int front, rear, itemsNumber = 0;

    Queue(int size) {
        this.queueSize = size;
        theQueue = new String[size];
    }

    public void insert(String value) {
        if (itemsNumber + 1 < queueSize) {
            theQueue[rear] = value;
            rear += 1;
            itemsNumber += 1;
        }
        else {
            System.out.println("The queue is full");
        }
    }

    public String remove() {
        String result = null;
        if (itemsNumber == 0) {
            System.out.println("The queue is empty");
        }
        else {
            result = theQueue[front];
            theQueue[front] = null;
            front += 1;
            itemsNumber -= 1;
        }
        return result;
    }

    public String peek() {
        return theQueue[front];
    }

    public boolean empty() {
        return itemsNumber == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(theQueue);
    }

    public static void main(String[] args) {
        Queue q = new Queue(10);

        q.insert("One");
        q.insert("Two");
        q.insert("Three");
        q.insert("Four");

        System.out.println(q);

        q.remove();

        System.out.println(q);
        System.out.println(q.peek());

    }

}
