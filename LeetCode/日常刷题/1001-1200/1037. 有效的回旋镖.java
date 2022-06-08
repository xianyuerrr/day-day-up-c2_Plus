class Solution {
    public boolean isBoomerang(int[][] points) {
        int [] point1 = points[0], point2 = points[1], point3 = points[2];
        if (pointEqual(point1, point2) || pointEqual(point1, point3) || pointEqual(point2, point3)) return false;
        return (point2[0] - point1[0]) * (point3[1] - point1[1]) != (point2[1] - point1[1]) * (point3[0] - point1[0]);
    }

    private boolean pointEqual(int [] point1, int [] point2) {
        return point1[0] == point2[0] && point1[1] == point2[1];
    }
}