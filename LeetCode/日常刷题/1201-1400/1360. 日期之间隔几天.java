class Solution {
    final int YEAR = 1971;
    final int [] MONTHS = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(dayFrom1971(date2) - dayFrom1971(date1));
    }

    // 目前使用的格里高利历闰年规则如下：
        // 公元年分非4的倍数，为平年。
        // 公元年分为4的倍数但非100的倍数，为闰年。
        // 公元年分为100的倍数但非400的倍数，为平年。
        // 公元年分为400的倍数为闰年。
    boolean isLeapYeay(int year) {
        return ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0));
    }

    private int dayFrom1971(String data) {
        int res = 0;
        String [] dataLis = data.split("-");
        int year = Integer.parseInt(dataLis[0]);
        int month = Integer.parseInt(dataLis[1]);
        int day = Integer.parseInt(dataLis[2]);
        res += (year - YEAR) * 365 
                + ((year - 1) / 4 - YEAR / 4) 
                - ((year - 1) / 100 - YEAR / 100)
                + ((year - 1) / 400 - YEAR / 400);
        for (int i = 0; i < month; i++) {
            res += MONTHS[i];
            if (i == 2 && isLeapYeay(year)) res++;
        }
        res += day - 1;
        return res;
    }
}