#include <iostream>
#include <map>
using namespace std;

int main() {
    int row;
    cin>>row;
    int mat[row][row];

    int * rotate(int * mat) {
        int row = sizeof(mat) / sizeof(mat[0]);
        // int col = sizeof(mat[0]) / sizeof(mat[0][0]);
        int new_mat[row][row];
        for (int i = 0; i < row, i++) {
            for (int j = 0; j < col; j++) {
                new_mat[j][row-1-i] = mat[i][j];
            }
        }
        return new_mat;
    }

    bool equal(int * mat1, int * mat2) {
        int row = sizeof(mat) / sizeof(mat[0]);
        // int col = sizeof(mat[0]) / sizeof(mat[0][0]);
        for (int i = 0; i < row, i++) {
            for (int j = 0; j < col; j++) {
                if (mat1[i][j] != mat2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    for (int i = 0; i < 4; i++) {
        if (equal(mat, rotate(mat))) {
            return 0 * 90;
        }
        mat = rotate(mat);
    }

}