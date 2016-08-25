package com.leafchild.structures.entity;

/**
 * @author: vmalyshev
 * Created: 8/16/16
 */
public class EntryNode {

    private String key;
    private String value;
    private EntryNode next;

    public EntryNode(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public EntryNode getNext() {
        return next;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setNext(EntryNode next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EntryNode entryNode = (EntryNode) o;

        if (getKey() != null ? !getKey().equals(entryNode.getKey()) : entryNode.getKey() != null) {
            return false;
        }
        return getValue() != null ? getValue().equals(entryNode.getValue()) : entryNode.getValue() == null;

    }

    @Override
    public int hashCode() {
        return getKey() != null ? getKey().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Key: " + this.getKey()
            + " Value: " + this.getValue();
    }

}
