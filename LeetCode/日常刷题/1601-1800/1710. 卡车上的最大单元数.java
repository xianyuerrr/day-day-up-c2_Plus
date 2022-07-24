import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return b[1] - a[1];
            }
        });
        int count = 0;
        for(int[] box : boxTypes){
            if(box[0] < truckSize){
                count += box[0] * box[1];
                truckSize -= box[0];
            }else {
                count += truckSize * box[1];
                return count;
            }
        }
        return count;
    }
}