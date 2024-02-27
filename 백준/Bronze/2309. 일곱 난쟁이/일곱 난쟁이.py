arr = [int(input()) for _ in range(9)]
used = [0]*9
path = [0]*9
ans = []
def dfs(level,cnt):
    global ans
    if cnt>100:
        return
    if level == 7:
        if cnt == 100:
            ans = path[:]
    for i in range(9):
        if used[i] == 1:
            return
        used[i] = 1
        path[level] = arr[i]
        dfs(level+1,cnt+arr[i])
        used[i] = 0
        path[level] = 0

dfs(0,0)
ans.sort()
for i in range(2,9):
    print(ans[i])
