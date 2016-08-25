package com.leafchild.structures;

import java.util.Arrays;

/**
 * Custom Stack implementation
 * Implements LIFO
 * Uses array of String for storing data
 * Has main method for tests
 * @author: vmalyshev
 * Created: 8/12/16
 */
public class Stack {

    private static String[] theStack;
    private int stackSize;
    private int topOfStack = -1;

    Stack(int size) {
        this.stackSize = size;
        theStack = new String[size];
    }

    public void push(String value) {
        if(topOfStack + 1 < stackSize) {
            topOfStack += 1;
            theStack[topOfStack] = value;
        } else {
            System.out.println("The stack is full");
        }
    }

    public String pop() {
        String result = null;
        if(topOfStack == -1) {
            System.out.println("The stack is empty");
        } else {
            result = theStack[topOfStack];
            theStack[topOfStack] = null;
            topOfStack--;
        }
        return result;
    }

    public String peek() {
        String result = null;
        if(topOfStack == -1) {
            System.out.println("The stack is empty");
        } else {
            result = theStack[topOfStack];
        }
        return result;
    }

    public boolean empty() {
        return topOfStack == -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(theStack);
    }

    public static void main(String[] args) {

        Stack stack = new Stack(10);

        stack.push("One");
        stack.push("Two");
        stack.push("Three");

        System.out.println(stack);

        stack.pop();

        System.out.println(stack);
        System.out.printf(stack.peek());

    }

}
