#include <bits/stdc++.h>

using namespace std;

int main() {
    int score;
    char c;
    scanf("%d", &score);
    if (score >= 90) {
        c = 'A';
    } else if (score >= 80) {
        c = 'B';
    } else if (score >= 70) {
        c = 'C';
    } else if (score >= 60) {
        c = 'D';
    } else {
        c = 'E';
    }
    printf("%c", c);    
    return 0;
}
