class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int cntA = 0;
        int cntB = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 1) cntB++;
            else cntA++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0) {
                if (cntA == 0) break;
                cntA--;
            }
            else {
                if (cntB == 0) break;
                cntB--;
            }
        }
        return cntA + cntB;
    }
}