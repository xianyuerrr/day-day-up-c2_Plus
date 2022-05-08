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
    public int averageOfSubtree(TreeNode root) {
        int [] res = dfs(root);
        return res[0];
    }

    private int [] dfs(TreeNode node) {
        if (node == null) return new int [] {0, 0, 0};
        int [] left = dfs(node.left);
        int [] right = dfs(node.right);

        int res = left[0] + right[0];
        int sum = left[1] + right[1] + node.val;
        int cnt = left[2] + right[2] + 1;
        if (node.val == sum / cnt) res++;
        return new int[] {res, sum, cnt};
    }

    
}