class Solution {
    public String toLowerCase(String s) {
        // 使用 API
        return method1(s);

        // // 自己编写
        // return method2(s);
    }
    private String method1(String s) {
        return s.toLowerCase();

    }

    private String method2(String s) {
        StringBuilder res = new StringBuilder(s);
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) <= 'Z' && res.charAt(i) >= 'A') {
                res.setCharAt(i, (char) ('a' + res.charAt(i) - 'A'));
            }
        }
        return res.toString();
    }


}