class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0, r=numbers.length-1;
        int ans;
        while (l < r) {
            ans = numbers[l] + numbers[r];
            if (ans == target) break;
            else if (ans < target) l++;
            else r--;
        }
        return new int[] {l+1, r+1};
    }
}