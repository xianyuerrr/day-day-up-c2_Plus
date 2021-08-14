class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        count = Counter(sentence)
        return len(count.keys()) == 26