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
    public boolean isValid(TreeNode root, long lower, long upper){
        boolean res = false;
        if(root == null) return true;
        if(root.val > lower && root.val < upper){
            res = true;
        }
        boolean lh = isValid(root.left,lower,root.val);
        boolean rh = isValid(root.right,root.val,upper);
        return res && lh && rh;
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        long lower = Integer.MIN_VALUE;
        long upper = Integer.MAX_VALUE;
        return isValid(root,lower,upper);
    }
}
