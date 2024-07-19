from heapq import heappush,heappop
N,M,T = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]
used = [[[0,0] for _ in range(M)] for _ in range(N)]
di = [(0,1),(1,0),(-1,0),(0,-1)]
heap =[(0,0,0,0)]
arr[0][0] = 1
used[0][0][0] = 1
used[0][0][1] = 1
while heap:
    cnt,sword,y,x = heappop(heap)
    if cnt > T:
        continue
    if y == N-1 and x == M-1:
        print(cnt)
        break
    for i in range(4):
        dy = y+di[i][0]
        dx = x+di[i][1]
        if dy<0 or dy>=N or dx<0 or dx>=M:
            continue
        if used[dy][dx][sword] == 1:
            continue
        if arr[dy][dx] == 0:
            used[dy][dx][sword] = 1
            heappush(heap,(cnt+1,sword,dy,dx))
        elif arr[dy][dx] == 1 and sword == 1:
            used[dy][dx][sword] = 1
            heappush(heap,(cnt+1,sword,dy,dx))
        elif arr[dy][dx] == 2:
            used[dy][dx][1] = 1
            heappush(heap,(cnt+1,1,dy,dx))
else:
    print('Fail')
