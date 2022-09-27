class Solution {
    int[] nums;
    boolean[] visited;
    int n;
    public int[] shuffle(int[] nums, int n) {
        this.nums = nums;
        this.n = n;
        visited = new boolean[n << 1];
        for (int i = 0; i < n << 1; i++) {
            f(i);
        }
        return nums;
    }

    private void f(int i) {
        if (visited[i]) return;
        int nextI;
        if (i < n) {
            nextI = i << 1;
        } else {
            nextI = ((i - n) << 1) + 1;
        }
        if (i != nextI) {
            int now = nums[i];
            visited[i] = true;
            f(nextI);
            nums[nextI] = now;
        }
        return;
    }
}