class Solution {
    public int[] shortestToChar(String s, char c) {
        // 双层遍历，O(n*n)
        // 稀疏遍历，哈希表存下标，空间换时间，O(n*k)
        // 两次遍历
        int n = s.length();
        int [] res = new int [n];
        Arrays.fill(res, n);
        for (int i=0; i < n; i++) {
            if (s.charAt(i) == c) res[i] = 0;
            if (i > 0 && res[i-1] + 1 < res[i]) res[i] = res[i-1] + 1;
        }
        for (int i=n-1; i >= 0; i--) {
            if (s.charAt(i) == c) res[i] = 0;
            if (i < n-1 && res[i+1] + 1 < res[i]) res[i] = res[i+1] + 1;
        }
        return res;
    }
}