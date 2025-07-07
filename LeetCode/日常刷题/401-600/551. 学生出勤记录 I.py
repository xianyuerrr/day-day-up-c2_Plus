class Solution:
    def checkRecord(self, s: str) -> bool:
        absent = "A"
        late = "L"
        present = "P"
    
        return s.count(absent) < 2 and (late * 3) not in s
