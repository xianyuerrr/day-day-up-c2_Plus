import sys 
for line in sys.stdin:
    a = line.split()
n, dist = map(int, input().split())
nums = list(map(int, input().split()))