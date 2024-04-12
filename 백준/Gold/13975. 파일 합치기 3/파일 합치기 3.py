from heapq import heappush,heappop,heapify

T = int(input())
for t in range(1,T+1):
    N = int(input())
    heap = list(map(int,input().split()))
    heapify(heap)

    ans = 0
    while heap:
        if len(heap) == 1:
            break
        a,b = heappop(heap),heappop(heap)
        ans += a+b

        heappush(heap,a+b)

    print(ans)