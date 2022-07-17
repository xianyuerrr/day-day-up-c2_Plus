import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Stack;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        return method1(root);
    }

    /**
     * @description 递归
     */
    public List<Integer> method1(Node root) {
        if (root == null) return res;
        res.add(root.val);
        for (int i=0; i < root.children.size(); i++) {
            Node child = root.children.get(i);
            method1(child);
        }
        return res;
    }

    /**
     * @description 非递归
     */
    public List<Integer> method2(Node root) {
        if (root == null) return res;
        Stack<Node> stk = new Stack<>();
        Stack<Integer> stkIdx = new Stack<>();
        int idx = 0;
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                if (idx == 0) res.add(root.val);
                stkIdx.push(idx);
                root = (root.children != null && idx < root.children.size()) ? root.children.get(idx) : null;
                idx = 0;
            }
            root = stk.pop();
            idx = stkIdx.pop() + 1;
            if (idx >= root.children.size()) root = null;
        }
        return res;
    }

        /**
        * @description 非递归，优化版
        */
        public List<Integer> method3(Node root) {
             if (root == null) return res;
             Deque<Node> stack = new ArrayDeque<Node>();
             stack.push(root);
             while (!stack.isEmpty()) {
                 Node node = stack.pop();
                 res.add(node.val);
                 for (int i = node.children.size() - 1; i >= 0; --i) {
                     stack.push(node.children.get(i));
                 }
             }
             return res; 
         }
}