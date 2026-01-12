package solution;

import javax.swing.tree.TreeNode;

// easy
// 100. Same Tree
// https://leetcode.com/problems/same-tree/

// example
// Input: p = [1,2,3], q = [1,2,3]
// Output: true

// constrains
// The number of nodes in both trees is in the range [0, 100].
// -10^4 <= Node.val <= 10^4

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null && p == null) return true;

        if(q == null || p == null) return false;

        if(q.val != p.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

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
