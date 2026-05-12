package solution;

import java.math.BigInteger;

public class RangSumBTS {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        // BST has left side smaller
        if (root.val < low)
            return rangeSumBST(root.right, low, high);

        // BST has right side smaller
        if (root.val > high)
            return rangeSumBST(root.left, low, high);

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
