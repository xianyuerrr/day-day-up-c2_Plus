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
class Solution {
    private void next(Stack<TreeNode> stk) {
        TreeNode node = stk.pop();
        node = node.right;
        while (node != null) {
            stk.push(node);
            node = node.left;
        }
        return;
    }

    private void init(Stack<TreeNode> stk, TreeNode node) {
        while (node != null) {
            stk.push(node);
            node = node.left;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        init(stk1, root1);
        init(stk2, root2);

        while (!stk1.empty() && !stk2.empty()) {
            if (stk1.peek().val <= stk2.peek().val) {
                res.add(stk1.peek().val);
                next(stk1);
            } else {
                res.add(stk2.peek().val);
                next(stk2);
            }
        }
        while (!stk1.empty()) {
                res.add(stk1.peek().val);
                next(stk1);
            } 
        while (!stk2.empty()) {
            res.add(stk2.peek().val);
            next(stk2);
        }
        return res;
    }
}