import java.util.HashSet;

class Solution {
    public int findMaximumXOR(int[] nums) {
        // 1 <= nums.length <= 2 * 10**4
        // 0 <= nums[i] <= 2**31 - 1

        // 双层遍历，O(n*n)，复杂度过高，会超时
        // return method1(nums);

        // 从高位到低位逐步确定最大值，x = nums[i] ^ nums[j] -> nums[i] = x ^ nums[j]
        // 使用哈希表存储前缀
        // return method2(nums);

        // 使用前缀树存储前缀，无法判断是前缀还是 nums[i]，会错乱
        // e.g. 11 的前缀有 1，若表示为 10，则无法判断 nums 是否有 10，表示为 01 同理。
        // 但是可以利用前缀树寻找其异或最大值
        return method3(nums);
    }

    public int method3(int[] nums) {
        int res = 0;
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
            // 利用 search 寻找字典树中与 num 异或值最大的数，尝试更新 res
            res = Math.max(res, trie.search(num));
        }
        return res;
    }

    public int method2(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 30; i >= 0; i--) {
            // 第 31-i 个二级制位能否取 1 （右到左）

            // 将前缀保存在 set 中
            set.clear();
            for (int num : nums) set.add(num >> i);

            // 尝试将此位取为 1，判断是否存在 nums[i] = x ^ nums[j]
            res = (res << 1) + 1;
            boolean flag = false;
            for (int n : set) {
                if (set.contains(n ^ res)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) res -= 1;
        }
        return res;
    }

    private int method1(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }
}

class Trie {
    private Trie[] children;

    public Trie() {
        children = new Trie[2];
    }

    public void insert(int num) {
        Trie node = this;
        for (int i = 30; i >= 0; i--) {
            int index = (num >> i) & 1;
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
    }

    public int search(int num) {
        int res = 0;
        Trie node = this;
        for (int i = 30; i >= 0; i--) {
            int index = ((num >> i) & 1) ^ 1;
            if (node.children[index] == null) {
                index ^= 1;
                if (node.children[index] == null) return res;
                node = node.children[index];
                res <<= 1;
            } else {
                node = node.children[index];
                res = (res << 1) + 1;
            }
        }
        return res;
    }
}
