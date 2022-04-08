import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = Set.of(2, 3, 5, 7, 11, 13, 17,19, 23, 29);
        int res = 0;
        for (int i = left; i < right+1; i++) {
            if (set.contains((getBit(i)))) res++;

        }
        return res;
    }

    private int getBit(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n-1;
        }
        return res;
    }
}