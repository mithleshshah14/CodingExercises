import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeTopView {
    public static void printTopView(TreeNode root) {
        if (root == null) {
            return;
        }

        class QueueNode {
            TreeNode node;
            int hd; // Horizontal distance

            QueueNode(TreeNode node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<QueueNode> queue = new LinkedList<>();

        queue.add(new QueueNode(root, 0));

        while (!queue.isEmpty()) {
            QueueNode current = queue.poll();
            int hd = current.hd;
            TreeNode node = current.node;

            // If the horizontal distance is not in the map, add the current node
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.val);
            }

            // Enqueue left and right children with their updated horizontal distances
            if (node.left != null) {
                queue.add(new QueueNode(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new QueueNode(node.right, hd + 1));
            }
        }

        // Print the top view of the binary tree
        for (int val : topViewMap.values()) {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        System.out.println("Top view of the binary tree:");
        printTopView(root); // Output: 4 2 1 3 7
    }
}
