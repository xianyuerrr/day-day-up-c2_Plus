class Solution {
    public double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        int sumSalary = 0;
        int n = salary.length;
        for (int s : salary) {
            minSalary = Math.min(minSalary, s);
            maxSalary = Math.max(maxSalary, s);
            sumSalary += s;
        }
        return (sumSalary - maxSalary - minSalary) / (double)(n-2);
    }
}