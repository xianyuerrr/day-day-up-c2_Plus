#include <bits/stdc++.h>

using namespace std;
class Solution {
public:
    double getAdmissionLine(int k, vector<double>& scores) {
        sort(scores.begin(), scores.end());
        reverse(scores.begin(), scores.end());
        return scores[k-1];
    }
};