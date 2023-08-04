import java.util.*;

class TreeNodeNew {
    int val;
    TreeNodeNew left;
    TreeNodeNew right;

    TreeNodeNew(int val) {
        this.val = val;
    }
}

public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNodeNew root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNodeNew> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int rightMostValue = 0; // Variable to store the rightmost node value at each level

            for (int i = 0; i < levelSize; i++) {
                TreeNodeNew current = queue.poll();
                rightMostValue = current.val; // Update the rightmost value for the current level

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            result.add(rightMostValue); // Add the rightmost value to the result list
        }

        return result;
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
        TreeNodeNew root = new TreeNodeNew(1);
        root.left = new TreeNodeNew(2);
        root.right = new TreeNodeNew(3);
        root.left.left = new TreeNodeNew(4);
        root.left.right = new TreeNodeNew(5);
        root.right.left = new TreeNodeNew(6);
        root.right.right = new TreeNodeNew(7);
        root.left.right.right = new TreeNodeNew(8);

        List<Integer> rightSideView = rightSideView(root);
        System.out.println("Right side view of the binary tree:");
        System.out.println(rightSideView); // Output: [1, 3, 7, 8]
    }
}
