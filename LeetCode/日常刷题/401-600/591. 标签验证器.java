    import java.util.Stack;

    class Solution {
        public boolean isValid(String code) {
            int n = code.length();
            if (n < 4 || code.charAt(0) != '<' || !Character.isUpperCase(code.charAt(1))) return false;

            Stack<String> tagNameStk = new Stack<>();
            Stack<Integer> stk = new Stack<>();

            String cDataPre = "![CDATA[";
            int cDataPreLen = cDataPre.length();

            for (int i = 0; i < n; i++) {
                char c = code.charAt(i);
                if (c == '<') {
                    if (i+cDataPreLen < n && code.substring(i+1, i+1+cDataPreLen).equals(cDataPre)) {
                        int nxtIdx = i+1+cDataPreLen;
                        while (nxtIdx < n-2) {
                            if (code.charAt(nxtIdx) == ']' && code.charAt(nxtIdx+1) == ']' && code.charAt(nxtIdx+2) == '>') {
                                break;
                            } else {
                                nxtIdx++;
                            }
                        }
                        // System.out.println("cdata: " + code.substring(i+1+cDataPreLen, nxtIdx));
                        if (nxtIdx > n-2) return false;
                        i = nxtIdx + 2;
                    } else {
                        stk.push(i);
                    }
                } else if (c == '>') {
                    if (stk.empty()) continue;
                    String subStr = code.substring(stk.pop()+1, i);
                    // System.out.println(subStr);
                    if (subStr.startsWith("/")) {
                        if (!(!tagNameStk.empty() && tagNameStk.peek().equals(subStr.substring(1)))) return false;
                        tagNameStk.pop();
                        if (i < n-1 && tagNameStk.empty()) return false;
                    } else {
                        if (!checkTagName(subStr)) return false;
                        tagNameStk.push(subStr);
                    }
                }
            }
            // System.out.println(tagNameStk.size() + ", " + stk.size());
            return tagNameStk.empty() && stk.empty();
        }

        private boolean checkTagName(String name) {
            int n = name.length();
            if (n < 1 || n > 9) return false;
            for (int i = 0; i < n; i++) {
                if (!Character.isUpperCase(name.charAt(i))) return false;
            }
            return true;
        }
    }