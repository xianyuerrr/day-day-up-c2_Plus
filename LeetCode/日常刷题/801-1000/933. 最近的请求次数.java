import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {
    // 1 <= t <= 10**9
    // 保证每次对 ping 调用所使用的 t 值都 严格递增
    // 至多调用 ping 方法 10**4 次
    final private int diff = 3000;
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    /**
     * @Descirption 在时间 t 添加一个新请求,返回过去 3000 毫秒内发生的所有请求数（包括新请求）
     * @param t
     * @return
     */
    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - diff) queue.poll();
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */