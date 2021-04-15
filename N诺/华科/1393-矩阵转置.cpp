#include <bits/stdc++.h>

using namespace std;

int main() {
    int rows;
    scanf("%d", &rows);
    int v[rows][rows];
    for (int x{0}; x < rows; x++) {
        for (int y{0}; y < rows; y++) {
            scanf("%d", &v[x][y]);
        }
    }
    
    for (int x{0}; x < rows; x++) {
        for (int y{0}; y < rows; y++) {
            printf("%d ", v[y][x]);
        }
        printf("\n");
    }
    return 0;
}
