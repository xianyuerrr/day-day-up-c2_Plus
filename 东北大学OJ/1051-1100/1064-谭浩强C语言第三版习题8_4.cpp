#include <bits/stdc++.h>

using namespace std;

int main() {
    int row = 3, col = 3;
    int matrix[row][col];
    for (int j = 0; j < col; j++) {
        for (int i = 0; i < row; i++) {
            scanf("%d", &matrix[i][j]);
        }
    }
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
    return 0;
}
