import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // 由于是单线程，所以不会出现 xStart, yStart, xEnd, yEnd 这类情况
        int[] res = new int[n];
        final String START = "start";
        final String END = "end";
        Stack<Integer> stk = new Stack<Integer>();
        Stack<Integer> waitedTime = new Stack<Integer>();
        for (String log : logs) {
            String[] lines = log.split(":");
            int idx = Integer.parseInt(lines[0]);
            String flag = lines[1];
            int time = Integer.parseInt(lines[2]);
            if (flag.equals(START)) {
                stk.push(time);
                waitedTime.push(0);
            } else {
                int ans = time - stk.pop() + 1;
                res[idx] += ans - waitedTime.pop();
                if (!waitedTime.isEmpty()) {
                    int top = waitedTime.pop();
                    waitedTime.push(ans + top);
                }
            }
        }
        return res;
    }
}