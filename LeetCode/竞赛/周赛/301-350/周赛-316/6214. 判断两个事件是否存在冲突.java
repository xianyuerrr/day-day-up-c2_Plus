class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String s1 = event1[0];
        String s2 = event1[1];
        String s3 = event2[0];
        String s4 = event2[1];
        if (s1.compareTo(s4) > 0) return false;
        if (s3.compareTo(s2) > 0) return false;
        return true;
    }
}