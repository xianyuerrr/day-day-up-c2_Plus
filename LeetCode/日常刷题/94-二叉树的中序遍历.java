import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        // 非递归
        res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     res = new ArrayList<>();
    //     dfs(root);
    //     return res;
    // }

    // // 递归
    // private void dfs(TreeNode node) {
    //     if (node == null) return;
    //     dfs(node.left);
    //     res.add(node.val);
    //     dfs(node.right);
    // }
}