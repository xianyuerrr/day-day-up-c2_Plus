import java.util.Map;
import java.util.TreeMap;

class MyCalendarTwo {
    TreeMap<Integer, Integer> cnt;

    public MyCalendarTwo() {
        cnt = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(maxBook, ans);
            if (maxBook > 2) {
                cnt.put(start, cnt.getOrDefault(start, 0) - 1);
                cnt.put(end, cnt.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}

// class MyCalendarTwo {
//     List<int[]> booked;
//     List<int[]> overlaps;

//     public MyCalendarTwo() {
//         booked = new ArrayList<int[]>();
//         overlaps = new ArrayList<int[]>();
//     }

//     public boolean book(int start, int end) {
//         for (int[] arr : overlaps) {
//             int l = arr[0], r = arr[1];
//             if (l < end && start < r) {
//                 return false;
//             }
//         }
//         for (int[] arr : booked) {
//             int l = arr[0], r = arr[1];
//             if (l < end && start < r) {
//                 overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
//             }
//         }
//         booked.add(new int[]{start, end});
//         return true;
//     }
// }