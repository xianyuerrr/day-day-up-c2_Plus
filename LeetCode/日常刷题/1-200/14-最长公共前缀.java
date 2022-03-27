class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        int idx = 0;
        int maxIdx = Integer.MAX_VALUE;
        char c;
        boolean flag = true;
        for (String str : strs) {
            maxIdx = Math.min(maxIdx, str.length()-1);
        }
        
        while (idx <= maxIdx) {
            c = strs[0].charAt(idx);
            for (String str : strs) {
                if (str.charAt(idx) != c) {
                    flag = false;
                    break;
                }
            }
            if (!flag) { break; }
            idx++;
            res.append(c);
        }
        return res.toString();
    }
}