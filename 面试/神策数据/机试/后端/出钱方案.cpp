#include <bits/stdc++.h>

using namespace std;

int money[7] = {1, 2, 5, 10, 20, 50, 100};
int cnt[7];
int target;

vector<int> ans(7, 0);
set<vector<int>> res;

int dfs(int idx, int val) {
    // cout << idx << ' ' << val << endl;
        if (val > target) {return 0;}
        if (idx == 7) {
            if (val == target) {
                vector<int> aa(ans);
                res.insert(aa);
            }
            return 0;
        }
        dfs(idx+1, val);
        
        if (cnt[idx] > 0) {
            cnt[idx] -= 1;
            val += money[idx];
            ans[idx] += 1;

            dfs(idx, val);
            dfs(idx+1, val);
            
            ans[idx] -= 1;
            val -= money[idx];
            cnt[idx] += 1;
        }
        return 0;
    }


int main() {
    for (int i=0; i<7; i++) {
        cin >> cnt[i];
        // cout << money[i] << ' ' << cnt[i] << endl;
    }

    cin >> target;
    // cout << target;
    dfs(0, 0);
    // cout<< res.size()<<endl;
    for (set<vector<int>> ::iterator it=res.begin(); it != res.end(); it++) {
        for (int j=0; j<7; j++) {
            cout << (*it)[j];
            if (j != 7) {
                cout << ' ';
            }
        }
        cout << endl;
    }
    return 0;
}
