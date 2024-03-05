import heapq
N, M = map(int, input().split())
lst = [[] for _ in range(200001)]
for i in range(N):
    a,*b = map(int, input().split())
    for c in b:
        heapq.heappush(lst[c],i)

arr = list(map(int,input().split()))
ans = [0]*N

for i in arr:
    if lst[i]:
        ans[heapq.heappop(lst[i])] += 1
print(*ans)
