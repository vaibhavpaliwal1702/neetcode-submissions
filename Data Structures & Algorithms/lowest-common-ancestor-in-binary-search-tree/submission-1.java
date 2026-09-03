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
    //1st Sol
    // private TreeNode sol;
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (p == null && q == null && root == null)
    //         return null;
    //     if (p == null || q == null || root == null)
    //         return null;
    //     if(root.val > p.val && root.val > q.val){
    //         lowestCommonAncestor(root.left, p, q);
    //     }
    //     else if(root.val < p.val && root.val < q.val){
    //         lowestCommonAncestor(root.right, p, q);
    //     }
    //     else{
    //         sol = root;
    //     }
    //     return sol;
    // }

    //2nd Sol
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

}
