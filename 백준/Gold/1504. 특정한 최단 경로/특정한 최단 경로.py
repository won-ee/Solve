from heapq import heappop,heappush


def dijstra(st,ed):
    result = [21e8] * (N + 1)
    result[st] = 0
    heap =[(0,st)]

    while heap:
        price, ky = heappop(heap)
        if result[ky] < price:
            continue

        for next, next_price in arr[ky]:
            new_price = price + next_price
            if result[next] > new_price:
                result[next] = new_price
                heappush(heap, (new_price, next))
    return result[ed]


N,M = map(int,input().split())
arr = [[] for _ in range(N+1)]

for _ in range(M):
    a,b,c = map(int,input().split())
    arr[a].append((b,c))
    arr[b].append((a,c))

v1,v2 = map(int,input().split())

ret = min(dijstra(1,v1)+dijstra(v1,v2)+dijstra(v2,N),
          dijstra(1,v2)+dijstra(v2,v1)+dijstra(v1,N))
print(ret if ret< 21e8 else -1)

