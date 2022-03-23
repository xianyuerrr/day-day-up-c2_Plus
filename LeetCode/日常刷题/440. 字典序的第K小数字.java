import java.util.Stack;

class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[10];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - '0';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null && node.isEnd;
    }
}

class Solution {
    int k;
    int res;
    Stack<Integer> stk = new Stack<>();
    public int findKthNumber(int n, int k) {
        long curr = 1;
        k--;
        while (k != 0) {
            // System.out.println(curr + ", " + k);
            // 不能随便跳跃，存在 0-pow(10, diff) 的以外的数
            // int diff = getLen(n) - getLen((int)curr);
            // int mod = (int) Math.pow(10, diff) + diff - 1;
            // if (diff > 0 && curr + 1 <= n % mod && k > mod) {
            //     k -= mod;
            //     curr++;
            //     k--;
            //     continue;
            // }

            if (curr * 10 <= n) {curr *= 10;}
            else {
                if (curr+1 > n) curr /= 10;
                while (curr % 10 == 9) {
                    curr /= 10;
                }
                curr++;
            }
            k--;
        }
        res = (int) curr;

        // 建前缀树
        // this.k = k;
        // Trie trie = new Trie();
        // for (int i = 1; i <= n; i++) {
        //     trie.insert(Integer.toString(i));
        // }
        // dfs(trie);
        return res;
    }

    private int getLen(int n) {
        if (n == 0) return 0;
        int res = 0;
        while (n != 0) {
            res++;
            n /= 10;
        }
        return res;
    }

    private void dfs(Trie root) {
        if (root == null) return;
        if (root.isEnd) k--;
        if (k == 0) {
            for(int num : stk) {
                res = res * 10 + num;
            }
        }
        for (int i = 0; i < root.children.length; i++) {
            if (k == 0) return;
            stk.push(i);
            dfs(root.children[i]);
            stk.pop();
        }
        return;
    }
}