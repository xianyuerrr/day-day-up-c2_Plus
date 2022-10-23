import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        return method2(nums1, nums2);
    }

    public int[] method1(int[] nums1, int[] nums2) {
        int n = nums1.length;

        List<Integer> lis2 = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lis2.add(i);
        }
        lis2.sort((x, y) -> nums2[x] - nums2[y]);


        Arrays.sort(nums1);
        int[] res = new int[n];
        int left = 0;
        int right = n-1;
        for (int key : lis2) {
            while (left < n && nums1[left] <= nums2[key]) {
                res[lis2.get(right--)] = nums1[left++];
            }
            if (left == n) break;
            res[key] = nums1[left++];
        }
        return res;
    }

    public int[] method2(int[] nums1, int[] nums2) {
        int n = nums1.length;

        List<Integer> lis2 = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lis2.add(i);
        }
        Arrays.sort(nums1);
        lis2.sort((x, y) -> nums2[x] - nums2[y]);

        int left1 = 0;
        int right2 = n-1;
        for (int key : lis2) {
            while (left1 < n && nums1[left1] <= nums2[key]) {
                nums2[lis2.get(right2--)] = nums1[left1++];
            }
            if (left1 == n) break;
            nums2[key] = nums1[left1++];
        }
        return nums2;
    }
}

// class Solution {
//     public int[] advantageCount(int[] nums1, int[] nums2) {
//         int n = nums1.length;
//         Map<Integer, List<Integer>> map = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             List<Integer> list = map.getOrDefault(nums2[i], new ArrayList<>());
//             list.add(i);
//             map.put(nums2[i], list);
//         }
//         Arrays.sort(nums1); Arrays.sort(nums2);
//         int[] ans = new int[n];
//         for (int l1 = 0, l2 = 0, r2 = n - 1; l1 < n; l1++) {
//             int t = nums1[l1] > nums2[l2] ? l2 : r2;
//             List<Integer> list = map.get(nums2[t]);
//             int idx = list.remove(list.size() - 1);
//             ans[idx] = nums1[l1];
//             if (t == l2) l2++;
//             else r2--;
//         }
//         return ans;
//     }
// }
