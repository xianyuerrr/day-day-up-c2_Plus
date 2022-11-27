class Solution {
    public String reformatNumber(String number) {
        StringBuilder res = new StringBuilder();
        number = number.replace(" ", "");
        number = number.replace("-", "");
        int n = number.length();
        for (int i = 0; i < n; ) {
            if (n - i > 4 || n - i == 3) {
                res.append(number.substring(i, i+3));
                i += 3;
            } else {
                res.append(number.substring(i, i+2));
                i += 2;
            }
            if(i != n) res.append("-");
        }
        return res.toString();
    }
}