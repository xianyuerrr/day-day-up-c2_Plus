#include <stack>
// #include
#include <unordered_map>
#include <iostream>
using namespace std;

// unordered_map<char, int> icp{{'#, 0'}, {'(', 6}, {'*', 4}, {'/', 4}, {'%', 4},
//     {'+', 2}, {'-', 2}, {')', 1}};
//  isp;
unordered_map<char, int> icp, isp;
// 栈外(in coming priority)优先数、
// 栈内(in stack priority)优先数
int main() {
    // icp.insert(pair<char, int>('#', 0));
    // icp.insert(unordered_map<char, int>::value_type('#', 0));
    return 0;
}

int postfix(string expression) {
    stack<char> stk;
    char ch = '#', ch1, op;
    stk.push(ch);
    return 0;
}