class Solution:
    def capitalizeTitle(self, title: str) -> str:
        res = []
        for word in title.split():
            if len(word) <= 2:
                res.append(word.lower())
            else:
                res.append(word.capitalize())
        return " ".join(res)