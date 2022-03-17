import java.util.ArrayList;
import java.util.List;

class Solution {
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;
    static final int TARGET = 24;
    static final double EPSLION = 1e-6;
    
    public boolean judgePoint24(int[] cards) {
        List<Double> lis = new ArrayList<>();
        for (int card : cards) {
            lis.add((double) card);
        }
        return slove(lis);
    }

    private boolean slove(List<Double> lis) {
        if (lis.size() == 0) return false;
        if (lis.size() == 1) return Math.abs(lis.get(0) - TARGET) < EPSLION;
        int n = lis.size();
        List<Double> nextLis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) nextLis.add(lis.get(k));
                }
                for (int operation = 0; operation < 4; operation++) {
                    if (i > j && (operation == ADD || operation == MULTIPLY)) continue;
                    if (operation == ADD) {
                        nextLis.add(lis.get(i) + lis.get(j));
                    } else if (operation == MULTIPLY) {
                        nextLis.add(lis.get(i) * lis.get(j));
                    } else if (operation == SUBTRACT) {
                        nextLis.add(lis.get(i) - lis.get(j));
                    } else if (operation == DIVIDE) {
                        if (Math.abs(lis.get(j)) < EPSLION) continue;
                        nextLis.add(lis.get(i) / lis.get(j));
                    }
                    if (slove(nextLis)) return true;
                    nextLis.remove(nextLis.size()-1);
                }
                nextLis.clear();
            }
        }
        return false;
    }
}