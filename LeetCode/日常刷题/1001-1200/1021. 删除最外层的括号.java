class Solution {
    // public String removeOuterParentheses(String s) {
    //     int cnt = 0;
    //     int lastIdx = -1;
    //     StringBuilder res = new StringBuilder();
    //     for (int i = 0; i < s.length(); i++) {
    //         if (cnt == 0) lastIdx = i;
            
    //         if (s.charAt(i) == '(') cnt++;
    //         else cnt--;
    //         if (cnt == 0) res.append(s.substring(lastIdx+1, i));
    //     }
    //     return res.toString();
    // }

    public String removeOuterParentheses(String s) {
        int level = 0;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                level--;
            }
            if (level > 0) {
                res.append(c);
            }
            if (c == '(') {
                level++;
            }
        }
        return res.toString();
    }
}
