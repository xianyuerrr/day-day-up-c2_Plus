class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res=-1;
        int [] point = new int [] {x, y};
        int n = points.length;
        for (int i = 0; i < n; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                if (res == -1 || distance(points[i], point) < distance(points[res], point)) {
                    res = i;
                }
            }
        }        
        return res;
    }
    private int distance(int [] point1, int [] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}