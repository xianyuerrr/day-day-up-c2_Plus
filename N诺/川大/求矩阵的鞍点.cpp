#include <iostream>
#include <vector>
using namespace std;

const int check(int x, int y, vector<vector<int>> &mat) {
    int row=mat.size(), col=mat[0].size();
    for (int i=0; i < row; i++) {
        if (mat[i][y] < mat[x][y]) {
            return false;
        }
    }
    for (int j=0; j < col; j++) {
        if (mat[x][j] > mat[x][y]) {
            return false;
        }
    }
    return true;
}

int main () {
    int row, col;
    cin >> row >> col;
    vector<vector<int>> mat(row, vector<int>(col));
    bool flag=true;
    
    
    for (int i=0; i<row; i++) {
        for (int j=0; j<col; j++) {
            cin>>mat[i][j];
        }
    }


    for (int i=0; i<row; i++) {
        for (int j=0; j<col; j++) {
            if (check(i, j, mat)) {
                flag = false;
                cout << i+1 << ' ' << j+1 << ' ' << mat[i][j] << endl;
            }
        }
    }
    if (flag) { cout << "NO" << endl;}

    return 0;
}
