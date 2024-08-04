from  collections import deque
N,M = map(int,input().split())
Hy,Hx = map(int,input().split())
Ey,Ex = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]
di = [(1,0),(-1,0),(0,1),(0,-1)]
used = [[[0]*2 for _ in range(M)] for _ in range(N)]
used[Hy-1][Hx-1][1] = 1
q = deque()
q.append((Hy-1,Hx-1,1,0))

ans = -1
while q:
    y,x,wand,cnt = q.popleft()
    if y == Ey-1 and x == Ex-1:
        ans = cnt
        break
    for i in range(4):
        dy = di[i][0] + y
        dx = di[i][1] + x
        if dy<0 or dy>=N or dx<0 or dx>=M:continue
        if used[dy][dx][wand] == 1: continue
        if arr[dy][dx] == 1 and wand == 1:
            used[dy][dx][0] = 1
            q.append((dy,dx,wand-1,cnt+1))
        elif arr[dy][dx] == 0:
            used[dy][dx][wand] = 1
            q.append((dy,dx,wand,cnt+1))

print(ans)