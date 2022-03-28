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
    public int maxDepth(TreeNode root) {
        // // 递归
        // return method1(root);

        // 非递归
        return method2(root);
    }

    private int method2(TreeNode root) {
        int res=0;
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        
        TreeNode node = root;
        int level = 1;
        while (!stk1.isEmpty() || node != null) {
            while (node != null) {
                // // 先序
                // System.out.println(node.val + ", " + level);
                stk1.push(node);
                stk2.push(level);
                node = node.left;
                level++;
            }
            node = stk1.pop();
            level = stk2.pop();
            // 中序
            // System.out.println(node.val + ", " + level);
            res = Math.max(res, level);

            node = node.right;
            level++;
        }
        return res;

    }

    private int method1(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(method1(node.left), method1(node.right));
    }
}