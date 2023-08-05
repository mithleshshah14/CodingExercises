import java.util.*;

class TreeNodeBottm {
    int val;
    TreeNodeBottm left;
    TreeNodeBottm right;

    TreeNodeBottm(int val) {
        this.val = val;
    }
}

public class BinaryTreeBottomView {
    public static void printBottomView(TreeNodeBottm root) {
        if (root == null) {
            return;
        }

        class QueueNode {
            TreeNodeBottm node;
            int hd; // Horizontal distance

            QueueNode(TreeNodeBottm node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        Map<Integer, Integer> bottomViewMap = new TreeMap<>();
        Queue<QueueNode> queue = new LinkedList<>();

        queue.add(new QueueNode(root, 0));

        while (!queue.isEmpty()) {
            QueueNode current = queue.poll();
            int hd = current.hd;
            TreeNodeBottm node = current.node;

            // Update the map with the latest node at the current horizontal distance
            bottomViewMap.put(hd, node.val);

            // Enqueue left and right children with their updated horizontal distances
            if (node.left != null) {
                queue.add(new QueueNode(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new QueueNode(node.right, hd + 1));
            }
        }

        // Print the bottom view of the binary tree
        for (int val : bottomViewMap.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        /*
         *        1
         *      /   \
         *     2     3
         *    / \   / \
         *   4   5 6   7
         *        \
         *         8
         */
        TreeNodeBottm root = new TreeNodeBottm(1);
        root.left = new TreeNodeBottm(2);
        root.right = new TreeNodeBottm(3);
        root.left.left = new TreeNodeBottm(4);
        root.left.right = new TreeNodeBottm(5);
        root.right.left = new TreeNodeBottm(6);
        root.right.right = new TreeNodeBottm(7);
        root.left.right.right = new TreeNodeBottm(8);

        System.out.println("Bottom view of the binary tree:");
        printBottomView(root); // Output: 4 2 8 6 7
    }
}
