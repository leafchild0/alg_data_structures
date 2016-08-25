package com.leafchild.structures;

import com.leafchild.structures.entity.Node;

/**
 * Implementation of LinkedList
 * Uses additional Node class
 * Has main method for tests
 * @author: vmalyshev
 * Created: 8/15/16
 */
public class LinkedList {

    private Node head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(Node item) {
        if (head == null) {
            head = item;
        }
        else {
            item.setNext(head);
            head = item;
        }
    }

    public Node remove(String name) {
        Node current = head;
        Node prev = head;

        while (current != null) {
            if (current.getName().equals(name)) {
                prev.setNext(current.getNext());
                return current;
            }
            prev = current;
            current = current.getNext();
        }

        System.out.println("Item " + name + " was not found in the list");
        return null;

    }

    public Node find(String name) {
        Node current = head;

        while (current.getNext() != null) {
            if (current.getName().equals(name)) {
                return current;
            }
            else {
                current = current.getNext();
            }
        }
        System.out.println("Value " + name + " was not found in the list");
        return null;
    }

    public void printItems() {
        Node current = head;

        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        Node item1 = new Node("One");
        Node item2 = new Node("Two");
        Node item3 = new Node("Three");
        Node item4 = new Node("Four");

        LinkedList list = new LinkedList();
        list.insert(item1);
        list.insert(item2);
        list.insert(item3);
        list.insert(item4);

        System.out.println(list.isEmpty());

        list.printItems();

        System.out.println("Found value: " + list.find("Three"));
        System.out.println("Deleted value " + list.remove("Two"));

        list.printItems();
    }

}

