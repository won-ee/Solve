import heapq
V,E = map(int,input().split())
arr = [[] for _ in range(V+1)]
st = int(input())
for _ in range(E):
    a,b,c = map(int,input().split())
    arr[a].append((b,c))
ret = [21e8]*(V+1)
ret[st] = 0
heap = [(0,st)]

while heap:
    price,ky = heapq.heappop(heap)
    if price>ret[ky]:
        continue
    for next,next_price in arr[ky]:
        now = ret[next]
        new_price = next_price+price
        if now>new_price:
            ret[next] = new_price
            heapq.heappush(heap,(new_price,next))

for i in range(1,V+1):
    if ret[i] == 21e8:
        print('INF')
    else:
        print(ret[i])