#include <bits/stdc++.h>
using namespace std;
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* increasingBST(TreeNode* root) {
        stack<TreeNode *> stk;
        TreeNode res = TreeNode();
        TreeNode * ans = &res;
        TreeNode * pre;

        stk.push(root);

        while (!stk.empty()) {
            if (stk.top() -> left != nullptr) {
                // 这里必须要消去 left，否则会陷入死循环
                pre = stk.top();
                stk.push(pre -> left);
                pre -> left = nullptr;
                continue;
            }

            ans -> right = stk.top();
            stk.pop();
            ans = ans -> right;

            if (ans -> right != nullptr) {
                stk.push(ans -> right);
            }
        }
        return res.right;
    }
};