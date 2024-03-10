from collections import Counter


class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        secret_counter = Counter(secret)
        guess_counter = Counter(guess)
        bull_cnt = 0
        cow_cnt = 0
        for i in range(min(len(guess), len(secret))):
            if (secret[i] == guess[i]):
                bull_cnt += 1
                secret_counter[secret[i]] -= 1
                guess_counter[secret[i]] -= 1
        for k, cnt in guess_counter.items():
            cow_cnt += min(cnt, secret_counter[k])
        return f"{bull_cnt}A{cow_cnt}B"
