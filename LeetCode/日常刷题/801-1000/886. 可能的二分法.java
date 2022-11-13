import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    int[] colors;
    int length;
    int[][] dislikes;
    final int A = 1;
    final int B = 2;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // // 以不喜欢为边而对边进行dfs
        // return method1(n, dislikes);
        // 以节点进行dfs
        return method2(n, dislikes);
    }

    public boolean method2(int n, int[][] dislikes) {
        // 1 <= n <= 2000
        // 0 <= dislikes.length <= 10^4
        // ai < bi
        length = dislikes.length;
        this.dislikes = dislikes;
        colors = new int[n+1];
        List<List<Integer>> lis = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lis.add(new ArrayList<>());
        }
        for (int i = 0; i < dislikes.length; i++) {
            int x = dislikes[i][0];
            int y = dislikes[i][1];
            lis.get(x).add(y);
            lis.get(y).add(x);
        }
        for (int i = 0; i < n+1; i++) {
            if (colors[i] != 0) continue;
            if (!dfs2(i, A, colors, lis)) return false;
        }
        return true;
    }

    private boolean dfs2(int node, int color, int[] colors, List<List<Integer>> lis) {
        if (colors[node] != 0) {
            if (colors[node] != color) {
                return false;
            } else {
                return true;
            }
        } 
        colors[node] = color;
        for (int nextNode : lis.get(node)) {
            if (!dfs2(nextNode, getAnother(color), colors, lis)) return false;
        }
        return true;
    }

    public boolean method1(int n, int[][] dislikes) {
        // 1 <= n <= 2000
        // 0 <= dislikes.length <= 10^4
        // ai < bi
        colors = new int[n+1];
        length = dislikes.length;
        this.dislikes = dislikes;
        return dfs1(0);
    }

    private boolean dfs1(int idx) {
        if (idx == length) return true;
        boolean res = false;
        int x = dislikes[idx][0], y = dislikes[idx][1];
        if (colors[x] == 0 && colors[y] == 0) {
            colors[x] = A;
            colors[y] = B;
            res |= dfs1(idx+1);
            colors[x] = B;
            colors[y] = A;
            res |= dfs1(idx+1);
            colors[x] = 0;
            colors[y] = 0;
            return res;
        }

        if (colors[x] == 0) {
            colors[x] = getAnother(colors[y]);
            res |= dfs1(idx+1);
            colors[x] = 0;
        } else if (colors[y] == 0) {
            colors[y] = getAnother(colors[x]);
            res |= dfs1(idx+1);
            colors[y] = 0;
        } else {
            if (colors[x] == colors[y]) return false;
            res |= dfs1(idx+1);
        }

        return res;
    }

    private int getAnother(int i) {
        return 3 - i;
    }
}