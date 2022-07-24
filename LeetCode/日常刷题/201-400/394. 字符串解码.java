import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Character> cStk = new Stack<>();
        Stack<Integer> numStk = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                StringBuilder str = new StringBuilder();
                while (true) {
                    c = cStk.pop();
                    if (c == '[') {
                        str.reverse();
                        break;
                    } else {
                        str.append(c);
                    }
                }
                int cnt = numStk.pop();
                for (int j = 0; j < cnt; j++) {
                    for (int j2 = 0; j2 < str.length(); j2++) {
                        cStk.push(str.charAt(j2));
                    }
                }
            } else {
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                } else {
                    if (num != 0) {
                        numStk.push(num);
                        num = 0;
                    }
                    cStk.push(c);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!cStk.isEmpty()) {
            res.append(cStk.pop());
        }
        return res.reverse().toString();
    }
}