import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        boolean flag = false;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;
        while (node != null || !stk.empty()) {
            while (node != null) {
                stk.push(node);
                if (node.val > p.val) node = node.left;
                else node = null;
            }
            node = stk.pop();
            if (flag) return node;
            if (node.val == p.val) flag = true;
            node = node.right;
        }
        return null;
    }
}