/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean lh = false;
        boolean rh = false;
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val) {
            lh = isSameTree(p.left, q.left);
            rh = isSameTree(p.right, q.right);
        }
        if (p.val != q.val)
            return false;
        return lh && rh;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean lh = false;
        boolean rh = false;
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        if (isSameTree(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
