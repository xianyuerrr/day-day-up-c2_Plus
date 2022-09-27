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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode newRoot;
        TreeNode node = new TreeNode(val);
        if (root.val < val) {
            node.left = root;
            newRoot = node;
        } else {
            if (root.left == null || root.left.val < val) {
                node.left = root.left;
                root.left = node;
                newRoot = root;
            } else if (root.right == null || root.right.val < val) {
                node.right = root.right;
                root.right = node;
                newRoot = root;
            } else {
                insertIntoMaxTree(root.left, val);
                newRoot = root;
            }
        }
        return newRoot;
    }
}