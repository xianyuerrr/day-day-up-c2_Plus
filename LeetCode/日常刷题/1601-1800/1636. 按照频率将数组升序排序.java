import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] frequencySort(int[] nums) {
        List<Integer> lis = new ArrayList<>(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            lis.add(i, nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        lis.sort((item1, item2) -> {
            if (map.get(item1) != map.get(item2)) {
                return map.get(item1) - map.get(item2);
            }
            return item2 - item1;
        });
        int[] res = new int[lis.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = lis.get(i);
        }
        return res;
    }
}