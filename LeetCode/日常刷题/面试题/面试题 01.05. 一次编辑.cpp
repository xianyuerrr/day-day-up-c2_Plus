#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    bool oneEditAway(string first, string second) {
        int f_len = first.size(), s_len = second.size();
        // 将 插入 与 删除 两种情况合并
        if (f_len > s_len) {
            swap(first, second);
            swap(f_len, s_len);
        }
        // 如果长度差大于1，那么这两个串是无法通过插入、删除、替换来转为相同
        if (s_len - f_len > 1) {
            return false;
        }
        // 容错位
        bool can_false {true};
        int f_idx{-1}, s_idx{-1};
        while (f_idx++ < f_len-1 && s_idx++ < s_len-1) {
            // 检测到对应位置字符不同
            if (first[f_idx] != second[s_idx]) {
                // 如果容错位已经被使用，就不能包容这次错误了
                if (!can_false) return false;
                else {
                    // 消耗掉容错位
                    can_false = false;
                    // 如果两个串长度相同，则跳过这个可以通过替换操作补救的位
                    // 如果长度不同，那么短的串不能往后一位，长的串往后一位，做到长度上的匹配
                    if (f_len != s_len) {
                        f_idx--;
                    }
                }
            }
        }
        return true;
    }
};