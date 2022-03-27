    import java.util.Arrays;

    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            return method2(envelopes);
            // // LIS，以 i 位置结尾并包含 i 位置元素的序列长度为依据的 dp
            // // O(n*n)，超时
            // return method1(envelopes);
        }

        private int method2(int [][] envelopes) {
            int res=0;
            int n = envelopes.length;

            // [x, y] 的 x 相同时，应将 y 值大的放前面，
            // 以先找到 y 最小的信封来装已有的信封，
            // 再更新小信封为 y 更小的信封（因为是以 x 为主从小到大排序的）
            // 不然更新完 y 小的信封可能导致 y 大的信封不能把原本可以装入的小信封装入
            // e.g. 待装信封：[[12, 2], [12, 5]]，已装信封： [[2, 4]] -> [[12, 2]]
            Arrays.sort(envelopes, (x, y) -> {
                if (x[0] != y[0]) return x[0] - y[0];
                return y[1] - x[1];
            });

            // 发现没有必要比较 [x, y] 中的 x 了，因为是全数组从小到大排序的
            // int [][] dp = new int [n][2];
            // Arrays.fill(dp, new int [] {Integer.MAX_VALUE, Integer.MAX_VALUE});

            // i 代表装入信封数量 - 1， 0 位置是带上自己共 1 个信封的
            int [] dp = new int [n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            for (int [] envelope : envelopes) {
                // binarySearch 返回装信封最多的信封
                // int l = binarySearch(dp, 0, n-1, envelope) + 1;
                int l = binarySearch(dp, 0, n-1, envelope[1]) + 1;

                // if (envelope[0] < dp[l][0] && envelope[1] < dp[l][1]) {
                // 由于是按照 [x, y] 的 x 为主依据从小到大排序的，
                // 所以后面元素的 x 值都不会大于已经遍历过的元素
                // 而 y 值则有可能比之前更小
                if (envelope[1] < dp[l]) {
                    dp[l] = envelope[1];
                }
            }

            for (int i = n-1; i >= 0; i--) {
                if (dp[i] == Integer.MAX_VALUE) continue;
                res = i + 1;
                break;
            }
            return res;
        }

        private int binarySearch(int []nums, int l, int r, int target) {
            int m;
            while (l < r) {
                m = l + (r-l+1 >> 1);
                if (nums[m] <= target) l = m;
                else r = m-1;
            }
            return nums[l] >= target ? l-1 : l;
        }


        private int binarySearch(int [][] dp, int l, int r, int [] target) {
            int m;
            while (l < r) {
                m = l + (r-l+1 >> 1);
                if (dp[m][0] < target[0] && dp[m][1] < target[1]) l = m;
                else r = m-1;
            }
            return dp[l][0] < target[0] && dp[l][1] < target[1] ? l : -1;
        }

        private int method1(int [][] envelopes) {
            Arrays.sort(envelopes, (x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
                return x[1] - y[1];
            });
            int n = envelopes.length;
            int [] dp = new int [n];
            int res = 0;
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }