import java.util.Map;

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        boolean res = true;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int k : map.keySet()) {
            if (map.get(k) == 0) continue;
            // System.out.println(k);
            if (k < 0) {
                if (((-k) & 1) == 1 || map.getOrDefault(k/2, 0) < map.get(k)) {
                    res = false;
                    break;
                } else {
                    map.put(k/2, map.get(k/2) - map.get(k));
                }
            } else {
                if (map.getOrDefault(k<<1, 0) < map.get(k)) {
                    res = false;
                    break;
                } else {
                    map.put(k<<1, map.get(k<<1) - map.get(k));
                }
            }
        }
        return res;
    }
}