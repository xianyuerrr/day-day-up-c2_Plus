import java.util.ArrayDeque;

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
    class MyNode {
        int val;
        TreeNode node;
        public MyNode(int val, TreeNode node) {
            this.val = val;
            this.node = node;
        }

        
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int res = 1;
        ArrayDeque<MyNode> queue = new ArrayDeque<>();
        queue.add(new MyNode(0, root));
        while(!queue.isEmpty()) {
            int size = queue.size();
            res = Math.max(res, queue.getLast().val - queue.getFirst().val + 1);
            for (int i = 0; i < size; i++) {
                MyNode myNode = queue.poll();
                TreeNode node = myNode.node;
                int val = myNode.val;
                if (node.left != null) {
                    queue.offer(new MyNode((val << 1) + 1, node.left));
                }
                if (node.right != null) {
                    queue.offer(new MyNode((val << 1) + 2, node.right));
                }
            }
        }
        return res;
    }
}