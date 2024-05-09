def dfs(level, st):
    global ans
    if sum(path) != 0 and sum(path) != n:
        start = link = 0
        for i in range(n):
            for j in range(n):
                if path[i] == 1and path[j]== 1:
                    start += arr[i][j]
                elif path[i] == 0 and path[j] ==0:
                    link += arr[i][j]
        ans = min(ans,abs(start-link))

    if level == n:
        return

    for i in range(st, n):
        path[i] = 1
        dfs(level+1, i+1)
        path[i] = 0


n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]
path = [0] * n
ans = 21e8
dfs(0,0)
print(ans)