import java.util.ArrayDeque;
import java.util.Queue;

class MovingAverage {
    int size;
    Queue<Integer> q;
    double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        q = new ArrayDeque<>(size);
        sum = 0;
    }
    
    public double next(int val) {
        if (q.size() < size) {
            sum += val;
            q.offer(val);
            return sum / q.size();
        }
        sum -= q.poll();
        q.offer(val);
        sum += val;
        return sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */