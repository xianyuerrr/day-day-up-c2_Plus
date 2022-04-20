import java.util.HashSet;
import java.util.Set;

class Solution {
    String [] dic = new String [] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder ans = new StringBuilder();
            // for (int i = 0; i < word.length(); i++) {
            //     ans.append(dic[word.charAt(i)-'a']);
            // }
            
            // 还是这种更快
            for (char c : word.toCharArray()) {
                ans.append(dic[c-'a']);
            }
            set.add(ans.toString());
        }
        return set.size();
    }
}