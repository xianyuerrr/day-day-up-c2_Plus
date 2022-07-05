import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // 每个元素都 不相同
        int n = arr.length;
        // 2 <= arr.length <= 10^5
        // -10^6 <= arr[i] <= 10^6
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int val = arr[n-1] - arr[0];
        for (int i = 0; i < n-1; i++) {
            val = Math.min(val, arr[i+1] - arr[i]);
        }
        for (int i = 0; i < n-1; i++) {
            if (arr[i+1] - arr[i] == val) res.add(List.of(arr[i], arr[i+1]));
        }
        return res;
    }
}