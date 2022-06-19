import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int maxCnt = -1;
        for (Integer key : map.keySet()) {
            maxCnt = Math.max(maxCnt, map.get(key));
        }
        List<Integer> res = new ArrayList<>();

        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCnt) res.add(key);
        }
        int [] lis = new int [res.size()];
        for (int i = 0; i < lis.length; i++) {
            lis[i] = res.get(i);
        }
        return lis;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int val = dfs(root.left) + dfs(root.right) + root.val;
        map.put(val, map.getOrDefault(val, 0) + 1);
        return val;
    }
}