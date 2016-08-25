package com.leafchild.structures;

import com.leafchild.structures.entity.EntryNode;

/**
 * Custom implementation of HashMap
 * Uses array of Objects alike LinkedList
 * for storing data
 * Has main method for tests
 * @author: vmalyshev
 * Created: 8/16/16
 */
public class HashMap {

    private int size;
    private EntryNode[] dataItem;


    public HashMap(int capacity) {
        this.size = capacity;
        dataItem = new EntryNode[capacity];
    }

    public void put(String key, String value) {
        int hashVal = hash2(key);
        EntryNode node = new EntryNode(key, value);

        if(dataItem[hashVal] == null) {
            dataItem[hashVal] = node;
        } else {
            EntryNode prev = dataItem[hashVal];
            EntryNode curr = dataItem[hashVal];

            while(curr != null){
                if(curr.getKey().equals(key)) {
                    if(prev == null) {
                        node.setNext(curr.getNext());
                        dataItem[hashVal] = node;
                        return;
                    } else {
                        node.setNext(curr.getNext());
                        prev.setNext(node);
                        return;
                    }
                }
                prev = curr;
                curr = curr.getNext();
            }
            prev.setNext(node);
        }
    }

    public String get(String key) {
        int hashVal = hash2(key);

        if(dataItem[hashVal] == null) return null;
        else {
            EntryNode node = dataItem[hashVal];
            while (node != null) {
                if(node.getKey().equals(key)) return node.getValue();
                node = node.getNext();
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(String key) {
        int hashVal = hash2(key);

        if(dataItem[hashVal] == null) return false;
        else {
            EntryNode node = dataItem[hashVal];
            while (node != null) {
                if(node.getKey().equals(key)) return true;
                node = node.getNext();
            }
        }
        return false;
    }

    public boolean containsValue(String value) {
        boolean result = false;

        for (EntryNode node : dataItem) {
            if(node != null) result = containsValueInternal(node, value);

            if(result) break;
        }
        return result;
    }

    private boolean containsValueInternal(EntryNode node, String value) {
        if(node.getValue().equals(value)) return true;
        if(node.getNext() != null) containsValueInternal(node.getNext(), value);

        return false;
    }

    public EntryNode remove(String key) {
        int hashVal = hash2(key);

        if(dataItem[hashVal] == null) return null;
        else {
            EntryNode node = dataItem[hashVal];
            EntryNode prev = null;
            while (node != null) {
                if(node.getKey().equals(key)) {
                    if(prev == null) {
                        dataItem[hashVal] = dataItem[hashVal].getNext();
                        return node;
                    } else {
                        prev.setNext(node.getNext());
                        return node;
                    }
                }
                prev = node;
                node = node.getNext();
            }
        }
        return null;
    }

    private int hash1(String key) {
        if(key == null) return 0;

        return key.hashCode() * 31;
    }

    private int hash2(String key) {
        if(key == null) return 0;

        return Math.abs(key.hashCode()) % size;
    }

    public void display() {
        for (EntryNode item : dataItem) {
            if(item != null) displayItem(item);
        }
    }

    private void displayItem(EntryNode item) {
        System.out.println(item);
        if(item.getNext() != null) {
            System.out.print("\t");
            displayItem(item.getNext());
        }
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(5);

        hashMap.put("123", "Test1");
        hashMap.put("124", "Test1");
        hashMap.put("1", "reserser");
        hashMap.put("6786", "Test5");
        hashMap.put("11", "rtsrtsrts");
        hashMap.put("45", "srrtsrts");
        hashMap.put("6585", "rtsrtsrts");
        hashMap.put("1111", "кеыкеыкеы");

        hashMap.display();

        hashMap.put("1111", "Wrong");

        System.out.println("------------------------");

        System.out.println("Unexisting key: " + hashMap.get("Test"));
        System.out.println("Existing key: " + hashMap.get("1111"));

        System.out.println("Remove " + hashMap.remove("1"));

        hashMap.display();

        System.out.println("Contains value: " + hashMap.containsValue("Test"));
        System.out.println("Contains key: " + hashMap.containsKey("116756565"));
    }

}
