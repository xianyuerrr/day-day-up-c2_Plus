import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // // 朴素写法，超时
        // return method1(n, edges);

        // 树形dp
        return method2(n, edges);
    }
    public List<Integer> method2(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        /* 找到与节点 0 最远的节点 x */
        int x = findLongestNode(0, parent, adj);
        /* 找到与节点 x 最远的节点 y */
        int y = findLongestNode(x, parent, adj);
        /* 求出节点 x 到节点 y 的路径 */
        List<Integer> path = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            ans.add(path.get(m / 2 - 1));
        }
        ans.add(path.get(m / 2));
        return ans;
    }

    public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visit = new boolean[n];
        queue.offer(u);
        visit[u] = true;
        int node = -1;
  
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            node = curr;
            for (int v : adj[curr]) {
                if (!visit[v]) {
                    visit[v] = true;
                    parent[v] = curr;
                    queue.offer(v);
                }
            }
        }
        return node;
    }

    public List<Integer> method1(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int level = Integer.MAX_VALUE;

        List<List<Integer>> mat = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mat.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            mat.get(edges[i][0]).add(edges[i][1]);
            mat.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            boolean [] visited = new boolean[n];
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            int ans = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                ans++;
                if (ans > level) break;
                for (int j = 0; j < size; j++) {
                    int cur = q.poll();
                    visited[cur] = true;
                    for (int nextLevelNode : mat.get(cur)) {
                        if (visited[nextLevelNode]) continue;
                        q.offer(nextLevelNode);
                    }
                }
            }

            if (ans > level) continue;
            else if (ans == level) res.add(i);
            else {
                level = ans;
                res.clear();
                res.add(i);
            }
        }
        return res;
    }
}