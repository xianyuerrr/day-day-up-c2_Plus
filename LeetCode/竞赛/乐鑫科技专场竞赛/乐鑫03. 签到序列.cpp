class Solution {
public:
    int getKthNum(int k) {
        int cnt = 1; // 数字位数
        long cot = 9; // 数字个数
        long sum = 0;
        int l = 1;
        int a, b;

        while (sum < k) {
            sum += cot * cnt;
            if (sum >= k) {
                sum -= cot*cnt;
                break;
            }
            cnt++;
            cot *= 10;
            l *= 10;
        }
        
        k -= sum;
        a = l + k / cnt - 1;
        b = k % cnt;
        if (b == 0) {
            return a % 10;
        } else{
            a++;
            b = cnt - b + 1;
            while (--b) {
                a /= 10;
            }
            return a % 10;

        }

        return a % 10;


    }
};