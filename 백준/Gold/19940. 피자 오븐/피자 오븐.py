from heapq import heappop,heappush
import  sys
input = sys.stdin.readline
ans = []
for _ in range(int(input())):
    N = int(input())
    used = set()
    heap = []
    timeLst = [-1, 1, -10, 10, 60]

    if N > 60:
        x = N // 60
    else:
        x = 0

    heappush(heap,(x,[0,0,0,0,x],x*60))
    while heap:
        cnt,lst,now = heappop(heap)

        if now == N :
            lst.reverse()
            ans.append(lst)
            break

        for i in range(5):
            if now+timeLst[i] in used:
                continue
            used.add(now+timeLst[i])
            temp = lst[:]
            temp[i] += 1
            heappush(heap, (cnt+1,temp,now+timeLst[i]))

for i in ans:
    print(*i)