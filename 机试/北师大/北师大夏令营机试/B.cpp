#include <bits/stdc++.h>

using namespace std;

bool test(int *a, int*b, int &n) {
    int j;
    for (int i=0; i<n-1; i++) {
        j = i+1;
            if (a[i] < a[j]) {
                if (b[i] > b[j]) {return false;}
            } else if (a[i] > a[j]) {
                if (b[i] < b[j]) {return false;}
            
        }
    }
    return true;
}

int main() {
    int T, n;
    cin>>T;
    while (T--) {
        cin >> n;
        int a[n], b[n];
        for (int i=0; i<n; i++) {cin >> a[i];}
        for (int i=0; i<n; i++) {cin >> b[i];}
        if (test(a, b, n)) {
            cout << "Yes" << endl;
        } else {
            cout << "No" << endl;
        }
    }
    return 0;
}

