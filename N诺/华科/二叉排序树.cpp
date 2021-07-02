#include <iostream>
using namespace std;

struct node {
    int val;
    node *left, *right, *parent;
    node() {val=0; left=nullptr; right=nullptr; parent=nullptr;}
};

int insert(node *root, int val, node *parent) {
    if (root == nullptr) {
        *root = node();
        root->val = val;
        root->parent = parent;
        if (root->parent != nullptr) {
            if (root->parent->val > root->val) {
                root->parent->left = root;
            } else {
                root->parent->right = root;
            }
        }
        return parent == nullptr ? -1 : root->parent->val;
    } else if (root->val > val) {
        return insert(root->left, val, root);
    } else {
        return insert(root->right, val, root);
    }
}

int main() {
    int row, val, out;
    cin>>row;
    node *root = nullptr;

    while (row-- > 0) {
        cin>>val;
        out = insert(root, val, nullptr);
        cout<<out<<endl;
    }
    return 0;
}