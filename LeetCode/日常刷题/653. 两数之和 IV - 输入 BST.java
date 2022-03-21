import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    List<Integer> lis = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int n = lis.size();
        if (n < 2) return false;
        lis.sort((x, y) -> x-y);
        int l = 0, r = n-1;
        while (l < r) {
            if (lis.get(l) + lis.get(r) == k) break;
            else if (lis.get(l) + lis.get(r) > k) r--;
            else l++;
        }
        return l != r && lis.get(l) + lis.get(r) == k;
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        lis.add(root.val);
        dfs(root.right);
    }
}