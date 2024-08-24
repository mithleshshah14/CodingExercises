// Definition for a binary tree node.
class LCATreeNode {
    int val;
    LCATreeNode left;
    LCATreeNode right;

    LCATreeNode(int x) {
        val = x;
    }
}

public class LCA {

    public LCATreeNode lowestCommonAncestor(
            LCATreeNode root,
            LCATreeNode p,
            LCATreeNode q
    ) {
        if (root == null) return null;
        if ((root.val == p.val || root.val == q.val)) return root;
        LCATreeNode left = lowestCommonAncestor(root.left, p, q);
        LCATreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) return left; else return right;
    }

    // Helper method to create a binary tree for testing purposes
    public LCATreeNode createBinaryTree() {
        LCATreeNode root = new LCATreeNode(3);
        root.left = new LCATreeNode(5);
        root.right = new LCATreeNode(1);
        root.left.left = new LCATreeNode(6);
        root.left.right = new LCATreeNode(2);
        root.right.left = new LCATreeNode(0);
        root.right.right = new LCATreeNode(8);
        root.left.right.left = new LCATreeNode(7);
        root.left.right.right = new LCATreeNode(4);
        return root;
    }

    // Helper method to print the binary tree
    public void printBinaryTree(LCATreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public static void main(String[] args) {
        LCA lcaFinder = new LCA();

        // Create a binary tree
        LCATreeNode root = lcaFinder.createBinaryTree();

        // Nodes for which we want to find the LCA
        LCATreeNode p = new LCATreeNode(4);
        LCATreeNode q = new LCATreeNode(7);

        // Find the lowest common ancestor of nodes p and q
        LCATreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);

        // Print the value of the LCA
        if (lca != null) {
            System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
        } else {
            System.out.println("One or both of the nodes are not present in the binary tree.");
        }
    }
}
