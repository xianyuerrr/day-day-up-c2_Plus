class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int[] preSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + distance[i-1];
        }
        if (destination < start) {
            int ans = destination;
            int ans = destination;
            destination = start;
            start = ans;
        }
        return Math.min(preSum[destination] - preSum[start], preSum[start] + preSum[n] - preSum[destination]);
    }
}