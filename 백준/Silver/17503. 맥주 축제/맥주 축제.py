from heapq import heappush,heappop

N, M, K = map(int,input().split())
heap = []
arr = []

for _ in range(K):
    a,b = map(int,input().split())
    arr.append((b,a))
arr.sort()

cnt = flag = 0
for a,b in arr:
    heappush(heap,(b,a))
    cnt += 1
    flag += b
    if cnt >N:
        y,x = heappop(heap)
        flag -= y
    if len(heap) == N:
        if flag >= M:
            print(a)
            break
else:
    print(-1)
