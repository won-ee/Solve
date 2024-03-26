def dfs(y,x,cnt,SP):
    global ans
    if cnt == T:
        ans = max(ans, SP)
        return

    for i in range(4):
        dy = diy[i] + y
        dx = dix[i] + x
        if dy < 0 or dy >= R or dx < 0 or dx >= C:
            continue
        if arr[dy][dx] == '#':
            continue
        elif arr[dy][dx] == 'S':
            arr[dy][dx] = '.'
            dfs(dy, dx, cnt+1, SP + 1)
            arr[dy][dx] = 'S'
        elif arr[dy][dx] == '.':
            dfs(dy, dx, cnt + 1, SP)


R,C,T = map(int,input().split())
arr = [list(input()) for _ in range(R)]
diy,dix = [0,0,1,-1],[1,-1,0,0]
ans = 0

for i in range(R):
    for j in range(C):
        if arr[i][j] == 'G':
            arr[i][j] = '.'
            dfs(i, j, 0, 0)

print(ans)