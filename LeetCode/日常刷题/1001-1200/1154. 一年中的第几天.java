class Solution {
    private final int [] MONTHS = new int [] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public int dayOfYear(String date) {
        int res = 0;
        String [] dateLis = date.split("-");
        int year = Integer.valueOf(dateLis[0]);
        int month = Integer.valueOf(dateLis[1]);
        int day = Integer.valueOf(dateLis[2]);

        res += day;
        for (int i = 0; i < month; i++) {
            res += MONTHS[i];
            if (i == 2 && isLeapYear(year)) res++;
        }
        return res;
    }
}