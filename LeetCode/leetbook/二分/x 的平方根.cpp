class Solution {
public:
    int mySqrt(int x) {
        // return floor(sqrt(x));
        int l, m, r;
        long long ans;
        l = 0;
        r = x;
        while (l <= r) {
            m = l + (r-l >> 1);
            ans =  (long long)m*m;
            if (ans == x) return m;
            else if (ans > x) r = m - 1;
            else if (ans < x) l = m + 1;
        }
        return (long long)l*l > x ? l-1 : l;
    }
};