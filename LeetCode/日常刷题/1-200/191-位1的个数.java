class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
        int res=0;
        while (n != 0) {
            res++;
            n &= n-1;
        }
        // int arch = 32;
        // for(int i=0; i < arch; i++) {
        //     if ((n & 1) == 1) res++;
        //     n >>= 1;
        // }
        return res;
    }
}