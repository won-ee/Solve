from heapq import heappop,heappush

T = int(input())
for t in range(1,T+1):
    n,d,c = map(int,input().split())
    arr = [[] for _ in range(n+1)]
    for _ in range(d):
        a,b,s = map(int,input().split())
        arr[b].append((a,s))
    ret = [21e8] * (n+1)
    ret[c] = 0
    heap = [(0,c)]
    while heap:
        price,now = heappop(heap)
        if ret[now]<price:continue
        for next,next_price in arr[now]:
            if ret[next] > next_price + price:
                ret[next] = next_price + price
                heappush(heap,(next_price+price,next))
    ans = 0
    cnt = 0
    for i in range(n+1):
        if ret[i] != 21e8:
            if ans < ret[i]:
                ans = ret[i]
            cnt += 1
    print(cnt,ans)