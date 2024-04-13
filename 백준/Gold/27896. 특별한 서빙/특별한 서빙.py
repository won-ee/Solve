from heapq import heappop,heappush,heapify

N,M = map(int,input().split())
arr = list(map(int,input().split()))
ans = cnt = 0
heap = []

for i in range(N):
    cnt += arr[i]
    heappush(heap, -arr[i])
    if cnt+arr[i] >= M :
        while cnt>=M:
            ans += 1
            cnt += (heappop(heap)*2)

print(ans)