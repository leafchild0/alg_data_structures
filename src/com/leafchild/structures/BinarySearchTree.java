package com.leafchild.structures;

import com.leafchild.structures.entity.TreeNode;

/**
 * @author: vmalyshev
 * Created: 8/18/16
 */
public class BinarySearchTree {

    private TreeNode root;
    private int treeSize;

    public void addNode(int key) {
        TreeNode node = new TreeNode(key);
        treeSize += 1;

        if (root == null) {
            root = node;
        }
        else {
            TreeNode parent;
            TreeNode focus = root;

            while (true) {
                parent = focus;
                if (key < focus.getKey()) {
                    focus = focus.getLeft();
                    if (focus == null) {
                        parent.setLeft(node);
                        return;
                    }
                }
                else {
                    focus = focus.getRight();
                    if (focus == null) {
                        parent.setRight(node);
                        return;
                    }
                }
            }
        }
    }

    public int size() {
        return treeSize;
    }

    public void clearTree() {
        root = null;
    }

    public TreeNode find(int key) {
        TreeNode temp = root;
        while(temp != null) {

            if(temp.getKey() == key) return temp;
            if(temp.getKey() < key) temp = temp.getRight();
            else temp = temp.getLeft();

        }
        return temp;
    }

    public void delete(String key) {

    }

    /**
     * Traversal of the tree using recursion
     */

    public void inOrderTraversal(TreeNode rootNode) {
        if(rootNode != null) {
            inOrderTraversal(rootNode.getLeft());
            System.out.println(rootNode);
            inOrderTraversal(rootNode.getRight());
        }

    }
    public void preOrderTraversal(TreeNode rootNode) {
        if(rootNode != null) {
            System.out.println(rootNode);
            preOrderTraversal(rootNode.getLeft());
            preOrderTraversal(rootNode.getRight());
        }

    }
    public void postOrderTraversal(TreeNode rootNode) {
        if(rootNode != null) {
            postOrderTraversal(rootNode.getLeft());
            postOrderTraversal(rootNode.getRight());
            System.out.println(rootNode);
        }

    }

    public void levelOrderTraversal(TreeNode rootNode) {

    }

    /**
     * Iterative type of the similar traversal
     */
    public void levelOrderTraversal2(TreeNode rootNode) {}
    public void postOrderTraversal2(TreeNode rootNode) {}
    public void preOrderTraversal2(TreeNode rootNode) {}
    public void inOrderTraversal2(TreeNode rootNode) {}


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.addNode(41);
        tree.addNode(11);
        tree.addNode(16);
        tree.addNode(66);
        tree.addNode(2);
        tree.addNode(98);

        System.out.println("Tree size: " + tree.size());

        System.out.println("Found value 2: " + tree.find(2));

        System.out.println("In order traversal");
        tree.inOrderTraversal(tree.root);
        System.out.println("Pre order traversal");
        tree.preOrderTraversal(tree.root);
        System.out.println("Post order traversal");
        tree.postOrderTraversal(tree.root);

    }

}

