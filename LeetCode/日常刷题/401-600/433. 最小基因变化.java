import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        // start.length == 8
        // end.length == 8
        // 0 <= bank.length <= 10
        // bank[i].length == 8
        // start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
        int res = -1;
        boolean flag = false;
        // 数据量不大，使用BFS，可进阶为双向BFS
        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String s: bank) bankSet.add(s);

        char [] direction = new char [] {'A', 'C', 'G', 'T'};

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            while (size-- > 0) {
                String str = queue.poll();
                visited.add(str);
                if (str.equals(end)) {
                    flag = true;
                    break;
                }
                char [] cs = str.toCharArray();
                char reset;
                for (int i = 0; i < str.length(); i++) {
                    for (char c: direction) {
                        if (cs[i] == c) continue;
                        reset = cs[i];
                        cs[i] = c;
                        String nxtString = String.valueOf(cs);
                        cs[i] = reset;
                        // String nxtString = str.substring(0, i) + c + str.substring(i+1);
                        if (!visited.contains(nxtString) && bankSet.contains(nxtString)) queue.offer(nxtString);
                    }
                }
            }
            res++;
        }
        return flag ? res : -1;
    }
}