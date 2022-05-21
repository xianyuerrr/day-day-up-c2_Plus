class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        int row = strs.length, col = strs[0].length();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row-1; j++) {
                if (strs[j].charAt(i) > strs[j+1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}