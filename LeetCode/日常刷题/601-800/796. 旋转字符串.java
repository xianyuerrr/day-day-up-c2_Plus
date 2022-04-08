class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length(), m = goal.length();
        if (m != n) return false;
        boolean res = true;
        for (int begin = 0; begin < n; begin++) {
            res = true;
            for (int i = 0; i < n; i++) {
                // System.out.println(begin + ", " + i);
                if (s.charAt(i) != goal.charAt((begin+i)%n)) {
                    res = false;
                    break;
                }
            }
            if (res) break;
        }
        return res;
    }
}