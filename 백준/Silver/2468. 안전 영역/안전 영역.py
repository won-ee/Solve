from collections import deque

def bfs(ny,nx,nk):
    global visit
    diy = [0,0,1,-1]
    dix = [1,-1,0,0]
    q = deque()
    q.append([ny,nx])
    while q:
        y,x = q.popleft()
        for l in range(4):
            dy = diy[l]+y
            dx = dix[l]+x
            if dy<0 or dy>=N or dx<0 or dx>=N:
                continue
            if arr[dy][dx] <=nk:
                continue
            if visit[dy][dx] == 1:
                continue
            visit[dy][dx] = 1
            q.append([dy,dx])


N = int(input())
MAX = -21e8
arr = []
for _ in range(N):
    ar = list(map(int,input().split()))
    if MAX<max(ar):
        MAX = max(ar)
    arr.append(ar)

lst = [0]*(MAX+1)
for i in arr:
    for j in i:
        lst[j] = 1

ans = [0] *(MAX+1)
for k in range(MAX+1):
    if lst[k] == 1:
        visit = [[0]*N for _ in range(N)]
        cnt = 0
        for i in range(N):
            for j in range(N):
                if visit[i][j] == 0 and arr[i][j]>k:
                    visit[i][j] = 1
                    bfs(i,j,k)
                    cnt += 1
        ans[k] += cnt
if max(ans) == 0:
    print(1)
else:
    print(max(ans))