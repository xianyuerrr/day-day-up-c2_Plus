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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        TreeNode node = root;
        Stack<TreeNode> stk = new Stack<>();

        while (node != null || !stk.empty()) {
            while (node != null) {
                res.append(node.val);
                res.append(',');
                stk.push(node);
                node = node.left;
            }
            node = stk.pop();
            node = node.right;
        }
        if (res.length() != 0) res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;

        String [] strLis = data.split(",");
        
        int n = strLis.length;
        int [] lis = new int [n];
        for (int i = 0; i < n; i++) lis[i] = Integer.valueOf(strLis[i]);
        return dfs(lis, 0, n-1);
    }

    private TreeNode dfs(int [] lis, int l, int r) {
        if (l > r) return null;
        TreeNode root = new TreeNode(lis[l]);
        
        int leftBegin = l+1, rightBegin = binarySearchLeft(lis, l+1, r, lis[l]);
        if (rightBegin == r) rightBegin = lis[rightBegin] > lis[l] ? rightBegin : rightBegin+1;
        
        root.left = dfs(lis, leftBegin, rightBegin-1);
        root.right = dfs(lis, rightBegin, r);

        return root;
    }

    private int binarySearchLeft(int []nums, int l, int r, int target) {
        int m;
        while (l < r) {
            m = l + (r-l >> 1);
            if (nums[m] < target) l = m+1;
            else r = m;
        }
        return l;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;