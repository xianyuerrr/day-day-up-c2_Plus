class Solution {
    public int minCostToMoveChips(int[] position) {
        int n = position.length;
        int sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            if ((position[i] & 1) == 1) sumA++;
            else sumB++;
        }
        return Math.min(sumA, sumB);
    }
}