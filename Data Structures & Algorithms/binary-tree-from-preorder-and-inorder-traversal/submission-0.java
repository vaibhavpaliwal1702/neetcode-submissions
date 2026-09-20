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
    private int preIndex = 0; // tracks which preorder element is "next root" as we go

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i); // value -> its index in inorder, O(1) lookup
        }
        return build(preorder, 0, inorder.length - 1, inorderIndex);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd, Map<Integer, Integer> inorderIndex) {
        if (inStart > inEnd)
            return null;

        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        preIndex++; // is root ko "consume" kar liya, agla call agla element uthayega

        int mid = inorderIndex.get(rootVal); // rootVal ka index inorder me, O(1)

        root.left = build(preorder,inStart, mid-1, inorderIndex);
        root.right = build(preorder, mid+1, inEnd, inorderIndex);

        return root;
    }
}
