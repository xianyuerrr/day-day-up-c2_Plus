class TopVotedCandidate {
    int [] successPerson;
    int [] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        // 1 <= persons.length <= 5000
        // 0 <= persons[i] < persons.length
        // 0 <= times[i] <= 10**9
        // 平局的情况下，最近获得投票的候选人将会获胜
        // times 是一个严格递增的有序数组
        int n = persons.length; this.times = times;

        successPerson = new int [n];
        int [] cnt = new int [n];
        int maxP = -1;

        for (int i = 0; i < n; i++) {
            cnt[persons[i]]++;
            if (maxP == -1 || cnt[persons[i]] >= cnt[maxP]) maxP = persons[i];
            successPerson[i] = maxP;
        }
    }

    public int q(int t) {
        int n = times.length;
        int l = 0, r = n-1;
        while (l < r) {
            int m = l + (r - l >> 1) + 1;
            if (times[m] > t) r = m-1;
            else l = m;
        }
        return successPerson[l];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */