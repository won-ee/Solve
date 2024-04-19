from heapq  import heappop,heappush


def dijstra(flag,st):
    heap = [(0,st)]
    while heap:
        price, ky = heappop(heap)
        if price>ret[flag][ky]:continue

        for next, next_price in arr[ky]:
            if next_price+price < ret[flag][next]:
                ret[flag][next] = next_price+price
                heappush(heap,(next_price+price,next))

T = int(input())
for _ in range(T):
    N,M = map(int,input().split())
    arr = [[] for _ in range(N+1)]

    for _ in range(M):
        a, b, c = map(int,input().split())
        arr[a].append((b,c))
        arr[b].append((a,c))

    K = int(input())
    friend = list(map(int,input().split()))
    ret = [[21e8] * (N+1) for _ in range(K)]

    for i in range(K):
        ret[i][friend[i]] = 0
        dijstra(i,friend[i])

    ans = [0]*(N+1)
    for i in range(K):
        for j in range(N+1):
            ans[j] += ret[i][j]
    print(ans.index(min(ans)))
