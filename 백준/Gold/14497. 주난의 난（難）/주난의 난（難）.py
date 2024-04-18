from heapq import heappop,heappush


N,M = map(int,input().split())
sty,stx,edy,edx = map(lambda x:int(x)-1,input().split())
arr = [list(input()) for _ in range(N)]
di = [(0,1),(1,0),(-1,0),(0,-1)]
heap = [(0,sty,stx)]
used=[[21e8]*M for i in range(N)]
used[sty][stx]=0

while heap :
    cnt, y, x= heappop(heap)
    if used[y][x] < cnt:
        continue
    for i in range(4):
        dy = y + di[i][0]
        dx = x + di[i][1]

        if -1 < dy < N and -1 < dx < M:
            newcnt = cnt + (arr[dy][dx] != '0')
            if newcnt < used[dy][dx]:
                used[dy][dx] = newcnt
                heappush(heap , (newcnt, dy, dx))

print(used[edy][edx])