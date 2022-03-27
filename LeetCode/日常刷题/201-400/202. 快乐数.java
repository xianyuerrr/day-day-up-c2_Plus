import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        // set
        int num = n;
        Set<Integer> visited = new HashSet<>();
        while (num != 1 && !visited.contains(num)) {
            visited.add(num);
            int ans = 0;
            while (num != 0) {
                ans += Math.pow(num % 10, 2);
                num /= 10;
            }
            num = ans;
        }
        return num == 1;
        // // map
        // int num = n;
        // Map<Integer, Boolean> visited = new HashMap<>();
        // while (num != 1 && visited.getOrDefault(num, false) == false) {
        //     visited.put(num, true);
        //     int ans = 0;
        //     while (num != 0) {
        //         ans += Math.pow(num % 10, 2);
        //         num /= 10;
        //     }
        //     num = ans;
        // }
        // return num == 1;
    }
}