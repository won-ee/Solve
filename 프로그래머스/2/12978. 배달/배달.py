from heapq import heappop,heappush
def solution(N, road, K):
    answer = 0
    arr = [[] for _ in range(N+2)]

    for i in road:
        arr[i[0]].append((i[1],i[2]))
        arr[i[1]].append((i[0],i[2]))

    heap = [(0,1)]
    ret = [21e8] * (N+1)
    ret[1] = 0
    while heap:
        price,now = heappop(heap)
        if ret[now] < price:
            continue
        for next,next_price in arr[now]:
            if next_price + price < ret[next]:
                ret[next] = next_price + price
                heappush(heap,(next_price+price,next))

    for i in ret:
        if i <=K:
            answer += 1
        
    
    return answer