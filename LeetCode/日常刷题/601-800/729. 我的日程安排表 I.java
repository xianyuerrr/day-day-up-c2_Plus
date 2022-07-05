import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    private List<int []> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // 0 <= start < end <= 10^9
        // 调用 book 方法的次数最多不超过 1000 次
        int n = calendar.size();
        if (n == 0) {
            calendar.add(new int [] {start, end});
            return true;
        }
        int idx = binarySearch(0, n-1, start);
        // System.out.println(idx);
        boolean flag = false;
        // 是不是所有区间的终点都大于 start
        if (calendar.get(idx)[1] > start) {
            if (end <= calendar.get(idx)[0]) {
                flag = true;
                calendar.add(idx, new int [] {start, end});
            }
        } else {
            if (idx + 1 == n || calendar.get(idx+1)[0] >= end) {
                flag = true;
                calendar.add(idx+1, new int [] {start, end});
            }
        }
        return flag;
    }

    /**
     * description 寻找终点小于等于 start 的最后一个区间
     */
    private int binarySearch(int l, int r, int target) {
        int m;
        while (l < r) {
            m = l + (r-l >> 1) + 1;
            if (calendar.get(m)[1] > target) r = m-1;
            else if (calendar.get(m)[1] <= target) l = m;
        }
        return l;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */