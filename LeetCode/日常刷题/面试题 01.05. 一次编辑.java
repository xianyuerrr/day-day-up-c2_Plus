class Solution {
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        if (Math.abs(m-n) > 1) return false;
        int k = 1;
        int IdxFirst = 0;
        int IdxSecond = 0;
        while (IdxFirst < m && IdxSecond < n) {
            if (first.charAt(IdxFirst) == second.charAt(IdxSecond)) {
                IdxFirst++;
                IdxSecond++;
            } else {
                if (k <= 0) return false;
                k--;
                if (m == n) {
                    IdxFirst++;
                    IdxSecond++;
                } else if (m < n) {
                    IdxSecond++;
                } else {
                    IdxFirst++;
                }
            }
        }
        return true;
    }
}