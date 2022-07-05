class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        boolean opeartion = true;
        int up = (int) (Math.pow(2, 31) - 1);
        int down = (int) (-Math.pow(2, 31));
        
        int l = 0;
        while (l < n && s.charAt(l) == ' ') l++;
        
        if (l < n && s.charAt(l) == '-') {opeartion = false; l++;}
        else if (l < n && s.charAt(l) == '+') {opeartion = true; l++;}
        
        int r = l;
        while (r < n && Character.isDigit(s.charAt(r))) r++;
        long res = 0;
        for (int i = l; i < r; i++) {
            res = res * 10 + (s.charAt(i) - '0');
            if (opeartion && res > up) {res = up; break;}
            if (!opeartion && -res < down) {res = -down; break;}
        }
        return opeartion ? (int) res : (int) (-res);
    }
}