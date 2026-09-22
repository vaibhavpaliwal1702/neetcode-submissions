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

public class Codec {
    public String res = "";
    public void preOrder(TreeNode node) {
        if (node == null) {
            res += "#";
            res += ",";
            return;
        }

        // Visit the current node first
        res += Integer.toString(node.val);
        res += ",";

        // Traverse the left subtree
        preOrder(node.left);

        // Traverse the right subtree
        preOrder(node.right);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        preOrder(root);
        return res;
    }

    private int index = 0; // shared pointer — Day56 ke preIndex jaisa

    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        String[] tokens = data.split(",");
        index = 0;
        return build(tokens);
    }

    private TreeNode build(String[] tokens) {
        String val = tokens[index];
        index++; // is token ko consume kar liya

        if (val.equals("#")) {
            return null; // blank 1
        }

        TreeNode node = new TreeNode(Integer.parseInt(val)); // blank 2: val ko int mein convert
        node.left = build(tokens); // blank 3
        node.right = build(tokens); // blank 4

        return node;
    }
}
