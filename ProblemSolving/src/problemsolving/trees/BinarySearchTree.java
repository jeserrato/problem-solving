package problemsolving.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class TreeNode {

    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int value;
    List<Integer> positions;

    public TreeNode() {
        this.positions = new ArrayList<>();
    }

}

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree(int... values) {
        this.root = new TreeNode();
        this.root.value = values[0];
        this.root.positions.add(0);

        for (int i = 1; i < values.length; i++) {
            boolean nodeExists = false;
            TreeNode y = null;
            TreeNode x = root;
            TreeNode z = new TreeNode();
            z.value = values[i];
            z.positions.add(i);

            while (x != null) {
                y = x;

                if (z.value == x.value) {
                    nodeExists = true;

                    break;
                } else if (z.value < x.value) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }

            if (nodeExists) {
                y.positions.add(i);
            } else {
                z.parent = y;

                if (y == null) {
                    this.root = z;
                } else if (z.value < y.value) {
                    y.left = z;
                } else {
                    y.right = z;
                }
            }
        }
    }

    public List<Integer> search(int value) {
        if (root == null) {
            return null;
        } else {
            return search(this.root, value);
        }
    }

    private List<Integer> search(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value == node.value) {
            return node.positions;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public void printInOrder() {
        if (this.root != null) {
            printInOrder(this.root);
        }
    }

    private void printInOrder(TreeNode node) {
        if (node == null)
            return;

        printInOrder(node.left);

        System.out.println(node.value);

        printInOrder(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(new int[] { 23, 36, 98, 333, 24, 12, 15, 16, 39, 45, 23, 333 });
        tree.search(333).stream().forEach(System.out::println);
        //tree.search(100).stream().filter(Objects::isNull).forEach(System.out::println);
        tree.search(23).stream().forEach(System.out::println);
        System.out.println(tree.toString());
        tree.printInOrder(tree.root);
    }

}
