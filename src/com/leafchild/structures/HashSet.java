package com.leafchild.structures;

/**
 * @author: vmalyshev
 * Created: 8/25/16
 */
public class HashSet<K> {

    private final java.util.HashMap<K, Object> entries;

    HashSet(int size) {
        entries = new java.util.HashMap<>(size);
    }

    public boolean isEmpty() {
        return entries.size() == 0;
    }

    public int size() {
        return entries.size();
    }


    public void add(K key) {
        if (!contains(key)) entries.put(key, null);
    }

    public boolean remove(K key) {
        entries.remove(key);
        return true;
    }

    public boolean contains(K key) {
        return entries.containsKey(key);
    }

    public void printItems() {

        for (K s : entries.keySet()) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        var set = new HashSet<String>(5);

        System.out.println("Is empty: " + set.isEmpty());

        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Three");
        set.add("Four");

        set.printItems();

        System.out.println("Size: " + set.size());

        System.out.println("Contains Four: " + set.contains("Four"));
        System.out.println("Contains Two: " + set.contains("Two"));
        System.out.println("Contains Two1111: " + set.contains("Two1111"));
        System.out.println("Removed item One " + set.remove("One"));

        set.printItems();
    }

}
