n,m = map(int,input().split())
arr = list(map(int,input().split()))
used=[0]*n
ans = -21e8

def dfs(level,cnt):
    global ans

    if level  == 3:
        if cnt<=m:
            if ans<cnt:
                ans = cnt
        return

    for i in range(n):
        if used[i] == 1:
            return
        used[i] = 1
        dfs(level+1,cnt+arr[i])
        used[i] = 0


dfs(0,0)
print(ans)