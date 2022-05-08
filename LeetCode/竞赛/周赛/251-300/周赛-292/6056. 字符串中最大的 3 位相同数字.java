class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i+1) 
                && num.charAt(i) == num.charAt(i+2) 
                && res.compareTo(num.substring(i, i+3)) < 0) {
                res = num.substring(i, i+3);
            }
        }
        return res;
    }
}