import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] sortByBits(int[] arr) {
        // 为啥不能直接使用 int [] 进行排序
        // Arrays.sort(arr, (x, y) -> countBits(x) - countBits(y));

        // Integer [] a = new Integer [arr.length];
        // for (int i = 0; i < arr.length; i++) {
        //     a[i] = arr[i];
        // }
        // Arrays.sort(a, (x, y) -> countBits(x) - countBits(y) != 0 ? countBits(x) - countBits(y) : x-y);
        // for (int i = 0; i < arr.length; i++) {
        //     arr[i] = a[i];
        // }
        return arr;
        // return Arrays.stream(arr).boxed().sorted((a, b) -> countBits(a) == countBits(b) ? a - b : countBits(a) - countBits(b)).mapToInt(Integer::intValue).toArray();
    }

    public int countBits(int num) {
        // 位运算hack
        int res = 0;
        while (num != 0) {
            num = num & (num - 1);
            res++;
        }
        return res;
    }
}