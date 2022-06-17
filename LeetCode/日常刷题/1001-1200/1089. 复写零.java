class Solution {
    public void duplicateZeros(int[] arr) {
        // method1(arr);
        method2(arr);
    }

    public void method1(int[] arr) {
        int n = arr.length;
        int [] lis = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (idx >= n) break;
            lis[idx++] = arr[i];
            if (idx >= n) break;
            if (arr[i] == 0) lis[idx++] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = lis[i];
        }
    }

    public void method2(int[] arr) {
        int n = arr.length;
        int top = 0;
        int i = -1;
        while (top < n) {
            i++;
            if (arr[i] != 0) {
                top++;
            } else {
                top += 2;
            }
        }
        int j = n - 1;
        if (top == n + 1) {
            arr[j] = 0;
            j--;
            i--;
        } 
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = arr[i];
                j--;
            } 
            i--;
        }
    }    
}