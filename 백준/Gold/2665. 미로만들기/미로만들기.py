from heapq import heappop,heappush

n = int(input())
arr = [list(map(int,input())) for _ in range(n)]
di = [(0,1), (1,0), (-1,0), (0,-1)]
heap = [(0, 0, 0)]
used = [[[0] * 4 for _ in range(n)] for _ in range(n)]


while heap:
    cnt, y, x = heappop(heap)

    if y == n-1 and x == n-1:
        print(cnt)
        break

    for i in range(4):
        dy = di[i][0] + y
        dx = di[i][1] + x
        if dy<0 or dy>=n or dx<0 or dx>=n:
            continue
        if used[dy][dx][i] ==1:
            continue
        if arr[dy][dx]==0:
            used[dy][dx][i] = 1
            heappush(heap,(cnt+1,dy,dx))
        else:
            used[dy][dx][i] = 1
            heappush(heap,(cnt,dy,dx))
else:
    print(0)