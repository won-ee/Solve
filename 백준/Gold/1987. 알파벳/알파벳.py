def dfs(y, x, cnt):
    global ans
    ans = max(ans,cnt)
    for k in range(4):
        dy = diy[k] + y
        dx = dix[k] + x
        if dy < 0 or dy >= N or dx < 0 or dx >= M:
            continue
        if arr[dy][dx] in lst:
            continue
        lst.add(arr[dy][dx])
        dfs(dy, dx, cnt+1)
        lst.remove(arr[dy][dx])


N, M = map(int, input().split())
arr = [list(input()) for _ in range(N)]
used = [[0] * M for _ in range(N)]
diy = [0, 0, 1, -1]
dix = [1, -1, 0, 0]
ans = 0
lst = set()
lst.add(arr[0][0])
dfs(0, 0, 1)
print(ans)