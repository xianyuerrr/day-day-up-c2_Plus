import java.util.ArrayList;
import java.util.List;

class Solution {
    private int m, n;
    private final int [][] directions = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1},
    };

    public List<String> findWords(char[][] board, String[] words) {
        // 1 <= words.length <= 3 * 104
        // 1 <= words[i].length <= 10
        // 前缀树
        return method1(board, words);

        // 根据每个单词，朴素的dfs寻找，超时
        // return method2(board, words);
    }

    public List<String> method2(char[][] board, String[] words) {
        m = board.length; n = board[0].length;

        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, i, j, '#', word, 0)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            if (flag) res.add(word);
        }
        return res;
    }

    private boolean dfs(char[][] board, int x, int y, char visited, String word, int idx) {
        if (!(board[x][y] == word.charAt(idx))) return false;
        if (idx == word.length()-1) return true;
        boolean res = false;
        board[x][y] = visited;
        for (int [] dir : directions) {
            int nextX = x + dir[0], nextY = y + dir[1];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;
            if (board[nextX][nextY] == visited) continue;
            if (dfs(board, nextX, nextY, visited, word, idx+1)) {
                res = true;
                break;
            }
        }
        board[x][y] = word.charAt(idx);
        return res;
    }


    public List<String> method1(char[][] board, String[] words) {
        // 1 <= words.length <= 3 * 104
        // 1 <= words[i].length <= 10
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        char visited = '#';
        StringBuilder strb = new StringBuilder(10);

        for (String word : words) trie.insert(word);

        m = board.length; n = board[0].length;
        // 不能从前缀树删除已匹配的 word，会造成大量重复计算
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(trie, board, i, j, visited, strb, res);
            }
        }
        return res;
    }

    private void dfs(Trie trie, char [][] board, int x, int y, char visited, StringBuilder strb, List<String> res) {
        strb.append(board[x][y]);
        Trie nxtTrie = trie.children[board[x][y] - 'a'];
        if (nxtTrie != null) {
            if (nxtTrie.isEnd) {
                res.add(strb.toString());
                nxtTrie.isEnd = false;
            }
            board[x][y] = visited;
            int nextX, nextY;
            for (int i=0; i < directions.length; i++) {
                nextX = x + directions[i][0];
                nextY = y + directions[i][1];
                if (!(0 <= nextX && nextX < m) || !(0 <= nextY && nextY < n) || board[nextX][nextY] == visited) continue;
                dfs(nxtTrie, board, nextX, nextY, visited, strb, res);
            }
            board[x][y] = strb.charAt(strb.length()-1);

            // 删除已遍历过的单词
            // 若不能遍历到叶节点，则不会删除；遍历到叶节点后，沿着单词删除
            if (nxtTrie.checkNull()) trie.children[board[x][y] - 'a'] = null;
        }
        strb.deleteCharAt(strb.length()-1);
    }
}

class Trie {
    Trie[] children;
    boolean isEnd;
    short cap = 0;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.cap++;
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean checkNull() {
        return cap == 0;
    }
}