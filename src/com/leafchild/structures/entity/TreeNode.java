package com.leafchild.structures.entity;

/**
 * @author: vmalyshev
 * Created: 8/25/16
 */
public class TreeNode {

    private int key;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TreeNode treeNode = (TreeNode) o;

        if (getKey() != treeNode.getKey()) {
            return false;
        }
        if (getLeft() != null ? !getLeft().equals(treeNode.getLeft()) : treeNode.getLeft() != null) {
            return false;
        }
        return getRight() != null ? getRight().equals(treeNode.getRight()) : treeNode.getRight() == null;

    }

    @Override
    public int hashCode() {
        return getKey();
    }

    @Override
    public String toString() {
        return "Key: " + this.getKey();
    }

}
