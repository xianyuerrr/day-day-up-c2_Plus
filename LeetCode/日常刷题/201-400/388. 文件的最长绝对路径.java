import java.util.Stack;

class Solution {
    public int lengthLongestPath(String input) {
        int res=0;
        String[] split = input.split("\n");
        Stack<String> stk = new Stack<>();
        int level = -1;
        int ans = 0;
        for (String s : split) {
            int idx = 0;
            while (idx < s.length()) {
                if (s.charAt(idx) == '\t') idx += 1;
                else break;
            }
            
            while (level >= idx) {
                ans -= stk.pop().length() + 1;
                level--;
            }
            
            stk.push(s.substring(idx));
            ans += 1 + s.length() - idx;
            level++;
            
            if (!stk.empty() && stk.peek().indexOf(".") != -1) {
                res = Math.max(res, ans);
                ans -= stk.pop().length() + 1;
                level--;
            }
        }
        return res == 0 ? 0 : res - 1;
    }
}