import java.util.Arrays;

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String w1 = Arrays.stream(word1).reduce("", (x, y) -> x+y);
        String w2 = Arrays.stream(word2).reduce("", (x, y) -> x+y);
        return w1.equals(w2);
    }
}