def dfs(y,x,hp,milk):
    global ans



    for i in range(len(milks)):
        if used[i] == 1:
            continue
        if abs(milks[i][0]-y) + abs(milks[i][1]-x) > hp:
            continue
        dist = abs(milks[i][0]-y) + abs(milks[i][1]-x)
        used[i] = 1
        dfs(milks[i][0],milks[i][1],hp+H-dist,milk+1)
        used[i] = 0

    if abs(home_y - y) + abs(home_x - x) <= hp:
        ans = max(ans, milk)


N,M,H = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]
diy = [0,0,1,-1]
dix = [1,-1,0,0]
home_y,home_x = 0,0
milks = []
ans = 0

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            home_y,home_x = i,j
        if arr[i][j] == 2:
            milks.append((i,j))
used = [0]*len(milks)
dfs(home_y,home_x,M,0)

print(ans)