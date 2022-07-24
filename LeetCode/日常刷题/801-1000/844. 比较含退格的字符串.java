import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        // 双指针可以把空间降为 O(1)
        Stack<Character> sStk = new Stack<>();
        Stack<Character> tStk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!sStk.isEmpty()) sStk.pop();
            } else {
                sStk.push(c);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!tStk.isEmpty()) tStk.pop();
            } else {
                tStk.push(c);
            }
        }
        if (sStk.size() != tStk.size()) return false;
        while (!sStk.isEmpty()) {
            if (sStk.pop() != tStk.pop()) return false;
        }
        return true;
    }
}