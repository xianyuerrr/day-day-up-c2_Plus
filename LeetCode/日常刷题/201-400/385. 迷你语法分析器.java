import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        int cnt;
        NestedInteger root = new NestedInteger();
        Stack<NestedInteger> stk = new Stack<>();
        NestedInteger node = root;
        int n = s.length();
        int idx = 1;

        int val;
        boolean negative;
        char c ;
        while (idx < n) {
            if (node == null) node = stk.pop();
            c = s.charAt(idx);
            if (c == '[') {
                idx++;
                NestedInteger nxtNode = new NestedInteger();
                node.add(nxtNode);
                stk.push(node);
                node = nxtNode;
            } else if (c == ']') {
                idx++;
                node = null;
            } else if (c == ',') {
                idx++;
            } else {
                val = 0;
                negative = false;
                if (c == '-') {
                    negative = true;
                    idx++;
                }
                for (int i = idx; i <= n; i++) {
                    if (i == n || !Character.isDigit(s.charAt(i))) {
                        idx = i;
                        break;
                    }
                    val = val * 10 + s.charAt(i) - '0';
                }
                if (negative) val = -val;
                node.add(new NestedInteger(val));
            }
        }
        return root;
    }
}