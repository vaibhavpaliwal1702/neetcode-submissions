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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sol = new LinkedList<>();
        if (root == null)
            return sol;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        while (pq.size() != 0) {
            int levelSize = pq.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = pq.poll();
                if (i == levelSize - 1)
                    sol.add(node.val);
                if (node.left != null)
                    pq.add(node.left);
                if (node.right != null)
                    pq.add(node.right);
            }
        }
        return sol;
    }
}
