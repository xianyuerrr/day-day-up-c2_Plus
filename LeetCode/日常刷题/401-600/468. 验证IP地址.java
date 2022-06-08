class Solution {
    public String validIPAddress(String queryIP) {
        final String IPV4 = "IPv4";
        final String IPV6 = "IPv6";
        final String OTHER = "Neither";
        
        if (isIPv4(queryIP)) return IPV4;
        if (isIPv6(queryIP)) return IPV6;
        return OTHER;
    }

    private boolean isIPv4(String queryIP) {
        int n = queryIP.length();
        char split = '.';
        byte cnt = 4;
        int last = -1;
        char c;

        for (int i = 0; i < n + 1; i++) {
            if (i == n) c = split;
            else c = queryIP.charAt(i);

            if (c == split) {
                if (--cnt < 0) return false;
                int length = i-1-last;
                if (length > 4 || length <= 0) return false;
                if (length > 1 && queryIP.charAt(last+1) == '0') return false;
                int ans = Integer.valueOf(queryIP.substring(last+1, i));
                if (ans > 255) return false;
                last = i;
            } else if (!Character.isDigit(c)) return false;
        }
        return cnt == 0 && queryIP.charAt(0) != split && queryIP.charAt(n-1) != split;
    }

    private boolean isIPv6(String queryIP) {
        int n = queryIP.length();
        char split = ':';
        byte cnt = 8;
        int last = -1;
        char c;

        for (int i = 0; i < n + 1; i++) {
            if (i == n) c = split;
            else c = queryIP.charAt(i);
            
            if (c == split) {
                if (--cnt < 0) return false;
                int length = i-1-last;
                if (length > 4 || length <= 0) return false;

                last = i;
            } else if (!Character.isDigit(c) && !(c <= 'f' && c >= 'a') && !(c <= 'F' && c >= 'A')) return false;
        }
        return cnt == 0 && queryIP.charAt(0) != split && queryIP.charAt(n-1) != split;
    }
}