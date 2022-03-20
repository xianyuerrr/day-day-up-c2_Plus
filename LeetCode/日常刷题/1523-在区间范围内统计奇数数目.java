class Solution {
    public int countOdds(int low, int high) {
        int length = high - low + 1;
        // if ((low & 1) == 1) {
        //     return length+1 >> 1;
        // } else {
        //     return length >> 1;
        // }
        return (low & 1) == 1 ? length+1 >> 1 : length >> 1;
    }
}