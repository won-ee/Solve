from heapq import heappop,heappush
n = int(input())
heap = []
for i in range(n):
    present = list(map(int,input().split()))
    if present[0] == 0 and len(heap) == 0:
        print(-1)
        continue
    elif present[0]  == 0 and len(heap) != 0:
        print(-heappop(heap))
        continue
    for i in range(1,present[0]+1):
        heappush(heap,-present[i])

