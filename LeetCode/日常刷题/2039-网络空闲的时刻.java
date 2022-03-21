import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        int root = 0;
        boolean [] visited = new boolean[n];
        List<Integer> [] adj = new List[n];
        for (int i = 0; i < n; i++) { adj[i] = new ArrayList<>(); }
        for (int []edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;
        int dist = 1;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int nextLevel : adj[curr]) {
                    if (visited[nextLevel]) continue;
                    visited[nextLevel] = true;
                    queue.offer(nextLevel);
                    int time = patience[nextLevel] * ((2 * dist - 1) / patience[nextLevel]) + 2 * dist + 1;
                    res = Math.max(res, time);
                }
            }
            dist++;
        }
        return res;
    }
}