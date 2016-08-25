package com.leafchild.structures.entity;

/**
 * @author: vmalyshev
 * Created: 8/15/16
 */
public class Node {

    private String name;
    private Node next;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Node getNext() {
        return next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName();
    }
}
