class Solution {
    public int subtractProductAndSum(int n) {
        int add=0, multiply=1;
        int val;
        while (n != 0) {
            val = n % 10;
            n /= 10;
            add += val;
            multiply *= val;
        }
        return multiply-add;
    }
}