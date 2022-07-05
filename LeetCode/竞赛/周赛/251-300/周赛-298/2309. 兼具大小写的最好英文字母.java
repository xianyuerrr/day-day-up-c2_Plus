class Solution {
    public String greatestLetter(String s) {
        // 最好 英文字母的大写和小写形式必须 都 在 s 中出现
        // 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现
        int up = 0;
        int low = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                up |= 1 << (c - 'A');
            } else {
                low |= 1 << (c - 'a');
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (((low >> i & 1) == 1) && ((up >> i & 1) == 1)) return String.valueOf((char) ('A' + i));
        }
        return "";
    }
}