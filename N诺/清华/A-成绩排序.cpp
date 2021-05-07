 #include <iostream>
#include <algorithm>
#include <string>
using namespace std;
struct node{
    string name;
    double grade;
};
bool cmp_up(node x,node y){
    return x.grade<y.grade;
}
bool cmp_down(node x,node y){
    return x.grade>y.grade;
}
node A[10005];
int main(){
    int n,t;
    cin>>n>>t;
    for(int i=0;i<n;i++){
        cin>>A[i].name>>A[i].grade;
    }
    if(t==0) stable_sort(A,A+n,cmp_down);
    if(t==1) stable_sort(A,A+n,cmp_up);
    for(int i=0;i<n;i++){
        cout<<A[i].name<<" "<<A[i].grade<<endl;
    }
    return 0;
}
 
// #include <bits/stdc++.h>

// using namespace std;

// int main() {
//     int rows, flag, grade, idx=0;
//     string name;
//     cin>>rows>>flag;

//     struct stu {
//         string name;
//         int grade;
//         int idx;
//         int flag;
//         stu(string name, int grade, int idx, int flag) : name(name), grade(grade), idx(idx), flag(flag) {};
//     };

//     struct cmp {
//         bool operator () (const stu &s1,const stu &s2) {
//             int flag = s1.flag;
//             if (s1.grade == s2.grade) {
//                 return s1.idx < s2.idx;
//             } else {
//                 return flag == 0 ? s1.grade < s2.grade : s1.grade > s2.grade;
//             }
//         }
//     };

    
//     priority_queue<stu, vector<stu>, cmp> pq;
//     while (idx++ < rows) {
//         cin>>name>>grade;
//         stu s(name, grade, idx, flag);
//         pq.push(s);
//     }
    
//     while (!pq.empty()) {
//         stu s = pq.top();
//         pq.pop();
//         cout<<s.name<<' '<<s.grade<<endl;
//     }
//     return 0;
// }

