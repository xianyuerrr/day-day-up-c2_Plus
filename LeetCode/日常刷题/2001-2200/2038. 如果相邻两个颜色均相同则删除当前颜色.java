class Solution {
    // public boolean winnerOfGame(String colors) {
    //     int Alice = 0, Bob = 0;
    //     for (int i = 1; i < colors.length()-1; i++) {
    //         if (colors.charAt(i) == colors.charAt(i-1) && colors.charAt(i) == colors.charAt(i+1)) {
    //             if (colors.charAt(i) == 'A') Alice++;
    //             else Bob++;
    //         }
    //     }
    //     return Alice > Bob;
    // }
    public boolean winnerOfGame(String colors) {
        int Alice = 0, Bob = 0;
        char status = '#';
        int cnt = 0;
        int n = colors.length();
        for (int i = 0; i < n+1; i++) {
            if (i < n && status == colors.charAt(i)) cnt++;
            else {
                int ans = cnt >= 3 ? cnt-2 : 0;
                if (status == 'A') Alice += ans;
                else Bob += ans;
                status = i < n ? colors.charAt(i) : '#';
                cnt = 1;
            }
        }
        return Alice > Bob;
    }
}