import java.util.LinkedList;
import java.util.List;

// 未知错误
class RangeModule {
    // 左闭右开区间
    // 1 <= left < right <= 10**9
    // 调用总数不超过 10**4 次
    List<Integer> L, R;
    int n;
    
    public RangeModule() {
        L = new LinkedList<>();
        R = new LinkedList<>();
        n = 0;
    }
    
    private int binarySearch(int left, int right) {
        int l = 0, r = n-1;
        while (l < r) {
            int m = l + (r-l >> 1);
            if (left >= R.get(m)) l = m+1;
            else if (right <= L.get(m)) r = m-1;
            else r = m;
        }
        return l;
    }

    private void check(int idx) {
        if (idx < 0) return;
        while (idx+1 < n && L.get(idx+1) <= R.get(idx)) {
            if (R.get(idx) >= R.get(idx+1)) {L.remove(idx+1); R.remove(idx+1); n--;}
            else {R.set(idx, R.get(idx+1)); L.remove(idx+1); R.remove(idx+1); n--;}
        }
    }

    public void addRange(int left, int right) {
        if (left >= right) return;
        int idx = -1, ll = Integer.MAX_VALUE, rr = Integer.MIN_VALUE;
        if (n != 0) {
            idx = binarySearch(left, right);
            ll = L.get(idx); rr = R.get(idx);
        }
        if (rr < left) {L.add(idx+1, left); R.add(idx+1, right); n++;}
        else if (ll <= left && right <= rr) return;
        else if (ll <= left && rr < right) {R.set(idx, right); check(idx);}
        else if (left < ll && right <= rr) {L.set(idx, left);}
        else if (left < ll && rr < right) {L.set(idx, left); R.set(idx, right); check(idx);}
    }
    
    public boolean queryRange(int left, int right) {
        if (n == 0) return false;
        int idx = binarySearch(left, right);
        if (L.get(idx) <= left && R.get(idx) >= right) return true;
        return false;
    }
    
    public void removeRange(int left, int right) {
        int idx = binarySearch(left, right);
        while (idx < n && !(L.get(idx) >= right || R.get(idx) <= left)) {
            int ll = L.get(idx), rr = R.get(idx);
            
            if (ll <= left && right <= rr) {R.set(idx, left); addRange(right, rr); break;}
            else if (ll <= left && rr < right) {R.set(idx, left); idx++;}
            else if (left < ll && right < rr) {L.set(idx, right);}
            else if (left < ll && rr < right) {L.remove(idx); R.remove(idx); n--;}
            else break;
        }
    }
}


/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */