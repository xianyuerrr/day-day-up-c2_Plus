import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] nextBigger = new int[nums2.length];
        int [] res = new int[nums1.length];
        Arrays.fill(nextBigger, -1);
        Stack<Integer> stk = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
            while (!stk.empty() && nums2[stk.peek()] < nums2[i]) {
                nextBigger[stk.pop()] = nums2[i];
            }
            stk.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextBigger[map.get(nums1[i])];
        }
        return res;
    }
}