class Solution {
    public String freqAlphabets(String s) {
        // // 有退格的遍历
        // return method1(s);

        // 无退格的遍历
        return method2(s);
    }

    private String method2(String s) {
        StringBuilder res = new StringBuilder();
        int i = -1, n = s.length();
        while (++i < n) {
            if (i+2 < n && s.charAt(i+2) == '#') {
                char c = (char) (s.charAt(i+1) - '0' + (s.charAt(i) - '0') * 10 - 1 + 'a');
                res.append(c);
                i += 2;
            } else {
                res.append((char) ('a' + s.charAt(i) - '1'));
            }
        }
        return res.toString();
    }

    private String method1(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                res.deleteCharAt(res.length()-1);
                res.deleteCharAt(res.length()-1);
                char c = (char) (s.charAt(i-1) - '0' + (s.charAt(i-2) - '0') * 10 - 1 + 'a');
                res.append(c);
            } else {
                res.append((char) ('a' + s.charAt(i) - '1'));
            }
        }
        return res.toString();
    }
}