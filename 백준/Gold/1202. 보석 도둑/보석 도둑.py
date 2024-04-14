from heapq import heappush,heappop
import sys
input = sys.stdin.readline

N,K = map(int,input().split())
jewels = [[*map(int,input().split())] for _ in range(N)]
bags = [int(input()) for _ in range(K)]
jewels.sort()
bags.sort()

ans = 0
heap = []

for bag in bags:
    while jewels and jewels[0][0] <= bag:
        heappush(heap,-jewels[0][1])
        heappop(jewels)
    if heap:
        ans -= heappop(heap)

print(ans)