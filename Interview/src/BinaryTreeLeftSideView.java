import java.util.*;

class TreeNodeN {
    int val;
    TreeNodeN left;
    TreeNodeN right;

    TreeNodeN(int val) {
        this.val = val;
    }
}

public class BinaryTreeLeftSideView {
    public static List<Integer> leftSideView(TreeNodeN root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNodeN> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNodeN current = queue.poll();

                // Add the leftmost node value to the result list at the start of each level
                if (i == 0) {
                    result.add(current.val);
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
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
        TreeNodeN root = new TreeNodeN(1);
        root.left = new TreeNodeN(2);
        root.right = new TreeNodeN(3);
        root.left.left = new TreeNodeN(4);
        root.left.right = new TreeNodeN(5);
        root.right.left = new TreeNodeN(6);
        root.right.right = new TreeNodeN(7);
        root.left.right.right = new TreeNodeN(8);

        List<Integer> leftSideView = leftSideView(root);
        System.out.println("Left side view of the binary tree:");
        System.out.println(leftSideView); // Output: [1, 2, 4]
    }
}
