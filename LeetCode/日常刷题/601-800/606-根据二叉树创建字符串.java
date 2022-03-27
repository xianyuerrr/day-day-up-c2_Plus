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
    StringBuilder res = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return res.toString();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        res.append(root.val);
        if (root.left == null && root.right == null) return;
        res.append('(');
        dfs(root.left);
        res.append(')');
        if (root.right == null) return;
        res.append('(');
        dfs(root.right);
        res.append(')');
    }
}