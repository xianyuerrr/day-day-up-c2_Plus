class Solution {
    public int nextGreaterElement(int n) {
        char [] ch = String.valueOf(n).toCharArray();
        int chLen = ch.length;
        int l = findLastIdx(ch);
        if (l == -1) return -1;
        int r = chLen - 1;
        while (ch[r] <= ch[l]) r--;
        swap(ch, l, r);
        // sort(ch, l+1, chLen-1);
        // 因为这部分原来就有序，所以只需要倒序
        reverse(ch, l+1, chLen-1);
        long res = getValFromCharArray(ch);
        return (int) res != res ? -1 : (int) res;
    }
    
    private void reverse(char [] ch, int l, int r) {
        while (l < r) {
            swap(ch, l++, r--);
        }
    }

    private void sort(char [] ch, int left, int right) {
        if (left >= right) return;
        int l = left, r = right;
        char target = ch[l];
        while (l < r) {
            while (l < r && ch[r] > target) r--;
            swap(ch, l, r);
            while (l < r && ch[l] <= target) l++;
            swap(ch, l, r);
        }
        sort(ch, left, l-1);
        sort(ch, l+1, right);
        return;
    }

    private void swap(char [] ch, int i, int j) {
        if (i < 0 || i >= ch.length || j < 0 || j >= ch.length) return;
        if (i == j) return;
        ch[i] += ch[j];
        ch[j] = (char) (ch[i] - ch[j]);
        ch[i] -= ch[j];
        return;
    }

    private long getValFromCharArray(char [] ch) {
        long res = 0;
        for (int i = 0; i < ch.length; i++) {
            res = res * 10 + (ch[i] - '0');
        }
        return res;
    }

    private int findLastIdx(char [] ch) {
        int n = ch.length;
        for (int i = n-1; i > 0; i--) {
            if (ch[i] > ch[i-1]) return i-1;
        }
        return -1;
    }
}