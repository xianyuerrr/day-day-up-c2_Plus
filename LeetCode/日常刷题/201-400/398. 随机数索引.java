import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class Solution {
    private int [] nums;
    // private HashMap<Integer, List<Integer>> map;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
        // map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     if (!map.containsKey(nums[i])) {
        //         map.put(nums[i], new ArrayList<>());
        //     }
        //     map.get(nums[i]).add(i);
        // }
    }

    /**
     *@Descirption: 假设给定的 target 一定在 nums 中
    **/
    public int pick(int target) {
        int res = -1;
        // 如果 pick 的调用次数不多，可以每次进行遍历，时间复杂度 O(n*k)
        // 如果调用次数很多，可以使用 hashmap 存储对应下标，随机选取

        // List<Integer> lis = map.get(target);
        // res = lis.get(random.nextInt(lis.size()));
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                cnt++;
                if (random.nextInt(cnt) == 0) res = i;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */