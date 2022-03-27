import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

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
    public boolean isSymmetric(TreeNode root) {
        // 递归
        // return root == null || check(root.left, root.right);

        // 非递归
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        if (root.left == null && root.right != null) return false;
        if (root.left != null && root.right == null) return false;
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()) {
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if (l.val != r.val) return false;
            if (l.left != null && r.right == null) return false;
            if (l.left == null && r.right != null) return false;
            if (!(l.left == null && r.right == null)) {
                q.offer(l.left); q.offer(r.right);
            }

            if (l.right != null && r.left == null) return false;
            if (l.right == null && r.left != null) return false;
            if (!(l.right == null && r.left == null)) {
                q.offer(l.right); q.offer(r.left);
            }
        }
        return true;
    }

    private boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (!(l != null && r != null)) return false;
        return l.val == r.val && check(l.left, r.right) && check(l.right, r.left);
    }
}