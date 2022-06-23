import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // 有 n 个专家从 0 到 n - 1 编号，1 <= meetings.length <= 10**5
        // meetings[i] = [xi, yi, timei] 表示专家 xi 和专家 yi 在时间 timei 要开一场会
        // 专家 0 有一个 秘密，分享给了专家 firstPerson，每次会议都会传播
        // 秘密共享是 瞬时发生 的，同一时间，一个专家不光可以接收到秘密，还能在其他会议上与其他专家分享
        // 按 任何顺序 返回答案
        return method2(n, meetings, firstPerson);
    }

    /**
     * @Description BFS
     */
    public List<Integer> method2(int n, int[][] meetings, int firstPerson) {
        boolean [] secrets = new boolean [n];
        // boolean [][] mat = new boolean [n][n];
        boolean [] visited = new boolean [n];
        secrets[0] = true; secrets[firstPerson] = true;
        
        Arrays.sort(meetings, (x, y) -> x[2] - y[2]);
        int idx = 0, nextIdx, cntM = meetings.length;
        while (idx < cntM) {
            Map<Integer,  Map<Integer, Boolean>> mat = new HashMap<>();

            Arrays.fill(visited, false);
            nextIdx = idx;
            Set<Integer> ans = new HashSet<>();
            while (nextIdx < cntM && meetings[idx][2] == meetings[nextIdx][2]) {
                int x = meetings[nextIdx][0], y = meetings[nextIdx][1];
                mat.putIfAbsent(x, new HashMap<>());
                mat.putIfAbsent(y, new HashMap<>());
                mat.get(x).put(y, true); mat.get(y).put(x, true);
                if (secrets[x]) ans.add(x);
                if (secrets[y]) ans.add(y);
                nextIdx++;
            }
            Queue<Integer> q = new LinkedList<>(ans);
            while (!q.isEmpty()) {
                int x = q.poll();
                if (visited[x]) continue;
                visited[x] = true; secrets[x] = true;
                for (int i : mat.get(x).keySet()) {
                    if (!visited[i]) q.offer(i);
                }
            }
            idx = nextIdx;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (secrets[i]) res.add(i);
        }
        return res;
    }

    /**
     * @Description 并查集
     */
    public List<Integer> method1(int n, int[][] meetings, int firstPerson) {
        Set<Integer> resSet = new HashSet<>();
        Map<Integer, Boolean> map = new HashMap<>();
        int [] lis = new int [n];
        
        // 初始化
        for (int i = 0; i < n; i++) lis[i] = i;
        lis[0] = 0; lis[firstPerson] = 0;
        resSet.add(0); resSet.add(firstPerson);
        
        Arrays.sort(meetings, (x, y) -> x[2] - y[2]);
        int len = meetings.length;
        int idx = 0;
        while (idx < len) {
            int nextIdx = idx;
            int time = meetings[idx][2];
            Set<Integer> ans = new HashSet<>();
            while (nextIdx < len && meetings[nextIdx][2] == time) {
                ans.add(meetings[nextIdx][0]); ans.add(meetings[nextIdx][1]);
                int x = find(lis, meetings[nextIdx][0]), y = find(lis, meetings[nextIdx][1]);
                nextIdx++;
                if (x == 0 && y == 0) continue;
                if (x == 0 && y != 0) lis[y] = x;
                else if (x != 0 && y == 0) lis[x] = y;
                else lis[x] = y;
            }
            for (int i : ans) if (find(lis, i) != 0) lis[i] = i;
            idx = nextIdx;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (find(lis, i) == 0) res.add(i);
        }
        return res;
    }

    private int find(int [] lis, int idx) {
        if (idx >= lis.length || lis[idx] == -1) return -1;
        if (idx == lis[idx]) return idx;
        return find(lis, lis[idx]);
    }
}