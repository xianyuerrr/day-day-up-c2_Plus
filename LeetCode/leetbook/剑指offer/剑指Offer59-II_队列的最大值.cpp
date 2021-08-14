#include <iostream>
#include <deque>
using namespace std;

class MaxQueue {
    deque<int> q1, q2;
public:
    MaxQueue() {
    }
    
    int max_value() {
        if (this -> q2.empty()) { return -1; }
        return this -> q2.front();
    }
    
    void push_back(int value) {
        this -> q1.push_back(value);
        while (!q2.empty() && value > this -> q2.back()) {
            this -> q2.pop_back();
        }
        this -> q2.push_back(value);
    }
    
    int pop_front() {
        if (this -> q1.empty()) {return -1;}
        int val = this -> q1.front();
        this -> q1.pop_front();
        if (val == this -> q2.front()) { this -> q2.pop_front(); }
        return val;
    }
};

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue* obj = new MaxQueue();
 * int param_1 = obj->max_value();
 * obj->push_back(value);
 * int param_3 = obj->pop_front();
 */