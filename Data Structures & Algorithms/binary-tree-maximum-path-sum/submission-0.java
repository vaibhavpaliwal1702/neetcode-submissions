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
    private int maxSum = Integer.MIN_VALUE;
    private int maxGain(TreeNode node) {
        if (node == null)
            return 0;

        int leftGain = Math.max(0,maxGain(node.left)); // left child se recurse karke, negative ho to 0 clamp
        int rightGain = Math.max(0,maxGain(node.right)); // right child se recurse karke, negative ho to 0 clamp

        int priceNewPath = node.val + leftGain + rightGain; // is node ke through "bend" karne wala path —
                                                // global max se compare hoga

        maxSum = Math.max(maxSum, priceNewPath);

        return node.val + Math.max(leftGain, rightGain); // parent ko kya return hoga — sirf ek side continue karte hue
    }
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
}
