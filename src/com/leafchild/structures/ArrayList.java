package com.leafchild.structures;

import com.leafchild.structures.entity.Node;

/**
 * Implementation of ArrayList
 * Uses array for storing data
 * Has main method for tests
 * @author: vmalyshev
 * Created: 8/15/16
 */
public class ArrayList {

    private Node[] array;
    private int listSize, itemsNumber = 0;

    ArrayList(int size) {
        array = new Node[size];
        this.listSize = size;
    }

    public boolean isEmpty() {
        return listSize == 0;
    }

    public int size() {
        return itemsNumber;
    }


    public void add(String name) {

        if(itemsNumber + 1 > listSize) {
            array = new Node[listSize * 2];
        }
        Node elem = new Node(name);

        array[itemsNumber] = elem;
        itemsNumber += 1;
    }

    public Node remove(int index) {
        Node elem = get(index);
        if(elem != null) {
            removeFromArray(index);
            itemsNumber -= 1;
        } else {
            System.out.println("Element has not been found " + index);
        }

        return elem;
    }

    private void removeFromArray(int index) {
        System.arraycopy(array, index + 1, array, index, itemsNumber);
    }

    public int indexOf(Node elem) {
        if(elem == null) return -1;

        for (int i = 0; i < itemsNumber; i++) {
            Node n = array[i];
            if(elem.getName().equals(n.getName())) {
                return i;
            }
        }
        return -1;
    }

    public Node get(int index) {
        if(index < 0 || index > itemsNumber) {
            System.out.println("Specified index is not found in the ArrayList: " + index);
            return null;
        }
        return array[index];
    }

    public void printItems() {
        for (int i = 0; i < itemsNumber; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {

        ArrayList list = new ArrayList(5);

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        list.printItems();

        System.out.println(list.isEmpty());
        System.out.println(list.size());

        System.out.println("Found item: " + list.get(5));
        System.out.println("Found item: " + list.get(2));

        System.out.println("Found item Four at position: " + list.indexOf(list.get(3)));

        System.out.println("Removed item " + list.remove(0));

        list.printItems();



    }

}

