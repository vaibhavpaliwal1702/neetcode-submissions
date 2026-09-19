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
    public int count = 0;
    public int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        kthSmallest(root.left,k);
        count++;
        if(count == k){
            res = root.val;
        }
        kthSmallest(root.right,k);
        return res;
    }
}
