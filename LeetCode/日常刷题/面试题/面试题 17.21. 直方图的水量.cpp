class Solution {
public:
    int trap(vector<int>& height) {
        if (height.empty()) return 0;
        int m{*max_element(height.begin(), height.end())};
        int n = height.size();
        int l{0}, r{n};
        int res{0};
        for (int i{1}; i <= m; i++) {
            while (height[l] < i) {
                l++;
            }
            while (height[r-1] < i) {
                r--;
            }
            if (l == r-1) {
                res += m-i+1;
                break;
            }
            res += r-l;
        }
        for (vector<int> :: iterator it{height.begin()}; it != height.end(); it++) {
            res -= *it;
        }
        return res;
    }
};