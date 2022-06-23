import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        return method4(n, edges);
    }

    public int method4(int n, int[][] edges) {
        int[] degree = new int[n];
        boolean[][] flags = new boolean[n][n];

        ArrayList<Integer>[] sets = new ArrayList[n];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            degree[edge[0] - 1]++;
            degree[edge[1] - 1]++;
        }

        Integer[] indexs = new Integer[n];
        for (int i = 0; i < indexs.length; i++) {
            indexs[i] = i;
        }

        Arrays.sort(indexs, new Comparator<Integer>(){
            @Override
            public int compare(Integer i, Integer j) {
                return degree[i] - degree[j];
            }
        });

        int[] f = new int[n];
        for (int i = 0; i < indexs.length; i++) {
            f[indexs[i]] = i;
        }

        Arrays.sort(degree);

        for (int[] edge : edges) {
            int x = f[edge[0] - 1];
            int y = f[edge[1] - 1];
            if (x > y) {
                x ^= y;
                y ^= x;
                x ^= y;
            }
            sets[x].add(y);
            flags[x][y] = true;
        }

        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer i, Integer j) {
                return degree[i] - degree[j];
            }
        };

        for (int i = 0; i < sets.length; i++) {
            Collections.sort(sets[i], comparator);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (degree[i] * 3 >= ans) {
                break;
            }
            for (int j : sets[i]) {
                if (degree[i] + (degree[j] << 1) >= ans) {
                    break;
                }
                for (int k : sets[j]) {
                    if (degree[i] + degree[j] + degree[k] >= ans) {
                        break;
                    }
                    if (flags[i][k]) {
                        ans = Math.min(ans, degree[i] + degree[j] + degree[k]);
                        break;
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans - 6;
    }

    public int method3(int n, int[][] edges) {
        int[] degree = new int[n + 1];
        boolean[][] flags = new boolean[n + 1][n + 1];

        ArrayList<Integer>[] sets = new ArrayList[n + 1];
        for (int i = 1; i < sets.length; i++) {
            sets[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            if (edge[0] > edge[1]) {
                // 交换两者，保持顺序
                edge[0] ^= edge[1];
                edge[1] ^= edge[0];
                edge[0] ^= edge[1];
            }
            sets[edge[0]].add(edge[1]);
            flags[edge[0]][edge[1]] = true;
        }

        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer i, Integer j) {
                return degree[i] - degree[j];
            }
        };

        //sets中的ArrayList按degree的值从小到大排序，用于最后一步截断。
        for (int i = 1; i < sets.length; i++) {
            Collections.sort(sets[i], comparator);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j : sets[i]) {
                for (int k : sets[j]) {
                    if (!flags[i][k]) {
                        continue;
                    }
                    ans = Math.min(ans, degree[i] + degree[j] + degree[k]);
                    //由于sets[j]已经按degree排序，所以找到的第一个即为确定i,j情况下的最优解，可以直接break出k的循环
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans - 6;
    }

    public int method2(int n, int[][] edges) {
        int ans = Integer.MAX_VALUE;
        int[] inDegrees = new int[n];
        boolean[][] isConnected = new boolean[n][n];
        for(int[] edge : edges){
            isConnected[edge[0] - 1][edge[1] - 1] = true;
            isConnected[edge[1] - 1][edge[0] - 1] = true;
            inDegrees[edge[0] - 1]++;
            inDegrees[edge[1] - 1]++;
        }
        // 还是连续空间遍历快
        for(int i = 0; i < n; i++) {
            for(int j = i+1 ; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(isConnected[i][j] && isConnected[j][k] && isConnected[k][i]) {
                        ans = Math.min(ans, inDegrees[i] + inDegrees[j] + inDegrees[k] - 6);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int method1(int n, int[][] edges) {
        // 2 <= n <= 400
        // 1 <= edges.length <= n * (n-1) / 2
        // 图中没有重复的边
        // 另一个顶点不在这个三元组内，即可算作一个度
        int res = Integer.MAX_VALUE;
        Set<Integer> [] mat = new Set[n+1];

        for (int i = 0; i < n+1; i++) mat[i] = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            mat[edges[i][0]].add(edges[i][1]); mat[edges[i][1]].add(edges[i][0]);
        }
        
        for (int i = 0; i < n+1; i++) {
            List<Integer> visited = new ArrayList<>(mat[i].size());
            for (int j : mat[i]) {
                if (j <= i) continue;
                visited.add(j);
            }
            for (int y : visited) {
                for (int z : visited) {
                    if (y >= z) continue;
                    if (mat[y].contains(z)) {
                        res = Math.min(res, mat[i].size() + mat[y].size() + mat[z].size() - 6);
                    }
                }
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        // 三元组数量很多，如果单独计算就会超时
        return res;
    }
}