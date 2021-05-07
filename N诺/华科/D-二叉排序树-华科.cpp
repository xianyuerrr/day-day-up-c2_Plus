#include <bits/stdc++.h>

using namespace std;

struct Node{
    // 必须赋初值，不然只是声明了，没有实体
    Node *left = nullptr;
    Node *right = nullptr;
    double val;
    Node(){};
    Node(double ans) : val(ans) {};
};

int main() {
    int count;
    double ans;
    cin>>count;

    Node *root = nullptr, *node = nullptr;
    while (count-- > 0) {
        cin>>ans;
        if (root == nullptr) {
            cout<<-1<<endl;
            // 这种写法超费时间，极度不推荐
            // Node n = Node(ans);
            // root = &n;
            root = new Node(ans);
        } else {
            node = root;
            while (true) {
                if (node->val <= ans) {
                    if (node->right == nullptr) {
                        cout<<node->val<<endl;
                        // Node n =Node(ans);
                        // node->right = &n;
                        node->right = new Node(ans);
                        break;
                    } else {
                        node = node -> right;
                    }
                } else {
                    if (node->left == nullptr) {
                        cout<<node->val<<endl;
                        // Node n =Node(ans);
                        // node->left = &n;
                        node->left = new Node(ans);
                        break;
                    } else {
                        node = node -> left;
                    }
                }
            }
        }
    }
    return 0;
}
