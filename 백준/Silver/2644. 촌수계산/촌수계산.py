n = int(input())
a,b = map(int,input().split())
arr = [[0]*(n+1) for _ in range(n+1)]
m = int(input())
used = [0] *(n+1)
ans = 21e8
for i in range(m):
    x,y = map(int,input().split())
    arr[x][y] = 1
    arr[y][x] = 1

def dfs(now,cnt):
    global ans
    if now == b:
        if ans>cnt:
            ans = cnt
    for i in range(n+1):
        if arr[now][i] == 0:
            continue
        if used[i] == 1:
            continue
        used[i] = 1
        dfs(i,cnt+1)
        used[i] = 0

dfs(a,0)
if ans == 21e8:
    print(-1)
else:
    print(ans)
