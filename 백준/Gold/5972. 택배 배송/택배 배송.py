from heapq import heappush,heappop

N, M = map(int,input().split())
arr = [[] for _ in range(N+1)]

for _ in range(M):
    a,b,c = map(int,input().split())
    arr[a].append((b,c))
    arr[b].append((a,c))

ret = [21e8] * (N+1)
ret[1] = 0
heap = [(0,1)]

while heap:
    price,ky = heappop(heap)
    if ret[ky]<price:
        continue
    for next,next_price in arr[ky]:
        new_price = price+next_price
        if ret[next]>new_price:
            ret[next] = new_price
            heappush(heap,(new_price,next))

print(ret[N])