import java.util.Stack;

class CQueue {
    private Stack<Integer> inStk;
    private Stack<Integer> outStk;
    
    public CQueue() {
        inStk = new Stack<>();
        outStk = new Stack<>();
    }
    
    public void appendTail(int value) {
        inStk.push(value);
    }
    
    public int deleteHead() {
        if (outStk.empty()) {
            while (!inStk.empty()) {
                outStk.push(inStk.pop());
            }
        }
        return outStk.empty() ? -1 : outStk.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */