import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        long res = 0;
        int n = nums.length;
        Integer[] lis1 = Arrays.stream(nums).boxed().toArray(Integer[] :: new);
        Integer[] lis2 = Arrays.stream(target).boxed().toArray(Integer[] :: new);

        Arrays.sort(lis1, (x, y) -> {
            if ((x & 1) != (y & 1)) return (x & 1) - (y & 1);
            return x - y;
        });
        Arrays.sort(lis2, (x, y) -> {
            if ((x & 1) != (y & 1)) return (x & 1) - (y & 1);
            return x - y;
        });

        for (int i = 0; i < n; i++) {
            res += Math.abs(lis1[i] - lis2[i]);
        }
        return res >> 2;
    }
}