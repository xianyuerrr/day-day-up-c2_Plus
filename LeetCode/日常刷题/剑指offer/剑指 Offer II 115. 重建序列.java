import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        // 最短 超序列 是 长度最短 的序列，并且所有序列 sequences[i] 都是它的子序列
        // 如果 nums 是序列的唯一最短 超序列 ，则返回 true ，否则返回 false
        // 子序列 是一个可以通过从另一个序列中删除一些元素或不删除任何元素，而不改变其余元素的顺序的序列
        // nums 是范围为 [1，n] 的整数的排列。还提供了一个 2D 整数数组 sequences ，
        // 其中 sequences[i] 是 nums 的子序列
        int n = nums.length;
        int[] cntIn = new int[n];
        List<Integer>[] edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length-1; i++) {
                cntIn[sequence[i+1] - 1]++;
                edges[sequence[i] - 1].add(sequence[i+1]);
            }
        }

        List<Integer> zero = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cntIn[i] == 0) {
                zero.add(i+1);
            }
        }
        int idx = 0;
        while (!zero.isEmpty()) {
            if (zero.size() != 1) {
                return false;
            }
            int now = zero.remove(0);
            if (now != nums[idx++]) return false;
            for (int i = 0; i < edges[now-1].size() ; i++) {
                cntIn[edges[now - 1].get(i) - 1]--;
                if (cntIn[edges[now - 1].get(i) - 1] == 0) {
                    zero.add(edges[now - 1].get(i));
                }
            }
        }
        return idx == n;
    }
}