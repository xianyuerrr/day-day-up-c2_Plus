class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int bulls = 0;
        int[] secretCnt = new int[10];
        int[] guessCnt = new int[10];
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretCnt[secret.charAt(i) - '0']++;
                guessCnt[guess.charAt(i) - '0']++;
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCnt[i], guessCnt[i]);
        }
        return bulls + "A" + cows + "B";
    }
}