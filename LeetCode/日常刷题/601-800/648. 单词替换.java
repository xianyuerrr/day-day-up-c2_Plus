import java.util.ArrayList;
import java.util.List;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // 1 <= dictionary.length <= 1000
        // 1 <= dictionary[i].length <= 100
        // 1 <= sentence.length <= 10^6
        String [] st = sentence.split(" ");
        List<String> res = new ArrayList<>(st.length);
        Trie trie = new Trie();
        for (String s : dictionary) trie.insert(s);
        for (String word : st) {
            int idx = trie.search(word);
            if (idx == -1) res.add(word);
            else res.add(word.substring(0, idx+1));
        }
        return String.join(" ", res);
    }

    class Trie {
        Trie[] children;
        boolean isEnd;
    
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
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
    
        public int search(String word) {
            int n = word.length();
            Trie node = this;
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                // 没有这样的词
                if (node.children[index] == null) {
                    return -1;
                }
                node = node.children[index];
                if (node.isEnd) return i;
            }
            // 有这样的词，但是并非 word 的前缀
            return -1;
        }
    }
}