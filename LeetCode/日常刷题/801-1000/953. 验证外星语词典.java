class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int [] map = new int [26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i)-'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            int flag = 0;
            int m = words[i-1].length(), n = words[i].length();
            // 只需要检查它们第一个不同的字母
            int j = 0;
            for (; j < Math.min(m, n); j++) {
                if (words[i-1].charAt(j) == words[i].charAt(j)) continue;
                break;
            }
            if (j == Math.min(m, n) && m > n) return false;
            else if (map[words[i-1].charAt(j) - 'a'] > map[words[i].charAt(j) - 'a']) return false;

            // for (int j = 0; j < Math.min(m, n); j++) {
            //     if (map[words[i-1].charAt(j) - 'a'] > map[words[i].charAt(j) - 'a']) flag = -1;
            //     else if (map[words[i-1].charAt(j) - 'a'] < map[words[i].charAt(j) - 'a']) flag = 1;
            //     else continue;
            //     if (flag == -1) return false;
            //     if (flag == 1) break;
            // }
            // if (flag == 0 && m > n) return false;
        }
        return true;
    }
}