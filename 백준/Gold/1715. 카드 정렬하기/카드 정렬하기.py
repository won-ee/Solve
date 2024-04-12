from heapq import heappush,heappop,heapify
import sys
input = sys.stdin.readline

N = int(input())
heap = []
for _ in range(N):
    heappush(heap,int(input()))

ans = 0
while heap:
    if len(heap) == 1:
        break
    a,b = heappop(heap),heappop(heap)
    ans += a+b

    heappush(heap,a+b)

print(ans)