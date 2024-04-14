from heapq import heappop,heappush

N = int(input())
arr = [[] for _ in range(N+1)]
M = int(input())
result = [21e8] * (N+1)

for _ in range(M):
    a,b,c = map(int,input().split())
    arr[a].append((b,c))

st,ed = map(int,input().split())

result[st] = 0
heap = [(0, st)]

while heap:
    price, ky = heappop(heap)
    if price >result[ky]:
        continue
    for next,next_price in arr[ky]:
        new_price = price + next_price
        if result[next]> new_price:
            result[next] = new_price
            heappush(heap, (new_price,next))
print(result[ed])
