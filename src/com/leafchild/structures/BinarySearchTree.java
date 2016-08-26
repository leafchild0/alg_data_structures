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

    public boolean remove(int key) {
        TreeNode temp = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        //Find the node
        while(temp.getKey() != key) {
            parent = temp;
            //Left child
            if(temp.getKey() > key) {
                isLeftChild = true;
                temp = temp.getLeft();
            } else {
                isLeftChild = false;
                temp = temp.getRight();
            }
            if(temp == null) return false;
        }

        //Three cases: no nodes, two nodes, one node
        if(temp.getLeft() == null && temp.getRight() == null) {
            if(temp.equals(root)) root = null;
            else if(isLeftChild) parent.setLeft(null);
            else parent.setRight(null);
        } else if(temp.getRight() == null) {
            if(temp.equals(root)) root = temp.getLeft();
            else if(isLeftChild) parent.setLeft(temp.getLeft());
            else parent.setRight(temp.getLeft());
        } else if(temp.getLeft() == null) {
            if(temp.equals(root)) root = temp.getRight();
            else if(isLeftChild) parent.setLeft(temp.getRight());
            else parent.setRight(temp.getLeft());
        }

        else {
            TreeNode replacement = getReplacementNode(temp);
            if(temp == root) root = replacement;
            else if(isLeftChild) parent.setLeft(replacement);
            else parent.setRight(replacement);

            replacement.setLeft(temp.getLeft());
        }
        treeSize -= 1;
        return true;

    }

    private TreeNode getReplacementNode(TreeNode node) {
        TreeNode parent = node;
        TreeNode replacement = node;
        TreeNode focus = node.getRight();

        while(focus != null) {
            parent = replacement;
            replacement = focus;
            focus = focus.getLeft();
        }
        if(replacement != node.getRight()) {
            parent.setLeft(replacement.getRight());
            replacement.setRight(node.getRight());
        }

        return replacement;
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
        int treeHeight = getMaxHeight(rootNode);

        for (int i = 1; i <= treeHeight; i++) {
            printLevelOrder(rootNode, i);
        }
    }

    private int getMaxHeight(TreeNode rootNode) {
        if(rootNode == null) return 0;
        int leftSub = getMaxHeight(rootNode.getLeft());
        int rightSub = getMaxHeight(rootNode.getRight());
        return (leftSub > rightSub) ? leftSub + 1 : rightSub + 1;
    }

    private void printLevelOrder(TreeNode parent, int level) {
        if(parent == null) return;
        if (level == 1) {
            System.out.println(parent);
        } else {
            printLevelOrder(parent.getLeft(), level - 1);
            printLevelOrder(parent.getRight(), level - 1);
        }
    }

    /**
     * Iterative type of the similar traversal
     */
    public void levelOrderTraversal2(TreeNode rootNode) {
        if (rootNode == null) {
            System.out.println("Empty tree");
        } else {
            java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
            queue.add(rootNode);
            while(!queue.isEmpty()) {
                TreeNode temp = queue.remove();
                System.out.println(temp);
                if(temp.getLeft() != null) queue.add(temp.getLeft());
                if(temp.getRight() != null) queue.add(temp.getRight());
            }
        }
    }

    public void inOrderTraversal2(TreeNode rootNode) {
        if(rootNode == null) {
            System.out.println("Empty tree");
        } else {
            java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
            TreeNode focus = rootNode;
            while(!stack.empty() || focus != null) {
                if (focus != null) {
                    stack.push(focus);
                    focus = focus.getLeft();
                } else {
                    focus = stack.pop();
                    System.out.println(focus);
                    focus = focus.getRight();
                }
            }
        }
    }

    public void postOrderTraversal2(TreeNode rootNode) {
        if(rootNode == null) {
            System.out.println("Empty tree");
        } else {
            java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
            stack.add(rootNode);
            TreeNode focus;
            TreeNode prev = root;
            while(!stack.empty()) {
                focus = stack.peek();
                //Only left child
                if(focus.getLeft() != null && !focus.getRight().equals(prev)
                    && !focus.getLeft().equals(prev)) {
                        stack.push(focus.getLeft());
                }
                else {
                    //Only right child
                    if (focus.getRight() != null && !focus.getRight().equals(prev)) {
                        stack.push(focus.getRight());
                    }
                    //In case this is leaf
                    else {
                        prev = stack.pop();
                        System.out.println(prev);
                    }

                }
            }
        }
    }

    public void preOrderTraversal2(TreeNode rootNode) {
        if(rootNode == null) {
            System.out.println("Empty tree");
        } else {
            java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
            stack.add(rootNode);
            TreeNode focus;
            while(!stack.empty()) {
                focus = stack.pop();
                System.out.println(focus);
                if(focus.getRight() != null) {
                    stack.add(focus.getRight());
                }
                if(focus.getLeft() != null) {
                    stack.add(focus.getLeft());
                }
            }
        }
    }


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

        //System.out.println("Delete node 11: " + tree.remove(11));

        System.out.println("In order traversal");
        tree.inOrderTraversal(tree.root);
        System.out.println("Pre order traversal");
        tree.preOrderTraversal(tree.root);
        System.out.println("Post order traversal");
        tree.postOrderTraversal(tree.root);
        System.out.println("Level order traversal");
        tree.levelOrderTraversal(tree.root);

    }

}

