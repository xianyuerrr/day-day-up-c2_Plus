import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {
    Stack<String> res = new Stack<>();
    int[][] dis;
    boolean[] visited;
    int beginIdx;
    int endIdx;
    int n;
    List<String> wordList;;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        // dfs
        return method1(beginWord, endWord, wordList);
    }

    public List<String> method1(String beginWord, String endWord, List<String> wordList) {
        this.wordList = wordList;
        wordList.add(beginWord);
        n = wordList.size();
        beginIdx = n-1;
        endIdx = wordList.indexOf(endWord);
        if (endIdx == -1) {
            return Collections.EMPTY_LIST;
        }
        visited = new boolean[n];
        dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            dis[i][i] = 0;
            for (int j = i+1; j < n; j++) {
                dis[i][j] = getDis(wordList.get(i), wordList.get(j));
                dis[j][i] = dis[i][j];
            }
        }
        dfs(beginIdx);
        return new ArrayList<>(res);
    }

    private boolean dfs(int x) {
        // System.out.println(wordList.get(x));
        visited[x] = true;
        res.push(wordList.get(x));
        if (x == endIdx) {
            return true;
        }
        for (int nextWordIdx = 0; nextWordIdx < n; nextWordIdx++) {
            if (visited[nextWordIdx] || dis[x][nextWordIdx] != 1) {
                continue;
            }
            if (dfs(nextWordIdx)) {
                return true;
            }
        }
        res.pop();
        return false;
    }

    private int getDis(String word1, String word2) {
        int res = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                res++;
                if (res == 2) {
                    break;
                }
            }
        }
        return res;
    }
}