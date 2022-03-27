class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 2) return true;
        int delteX = coordinates[1][0] - coordinates[0][0];
        int delteY = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i][0] - coordinates[i-1][0]) * delteY != 
                (coordinates[i][1] - coordinates[i-1][1]) * delteX) {
                return false;
            }
        }
        return true;
    }
}