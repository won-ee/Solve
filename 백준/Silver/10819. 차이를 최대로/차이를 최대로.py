n = int(input())
arr = list(map(int,input().split()))
used = [0]*n
path = [0]*n
MAX = -21e8
def dfs(level):
    global MAX
    if level == n:
        SUM = 0
        for i in range(n-1):
            SUM += abs(path[i]-path[i+1])
        if SUM>MAX:
            MAX = SUM
        return

    for i in range(n):
        if used[i] == 1:
            continue
        used[i] = 1
        path[level] = arr[i]
        dfs(level+1)
        used[i] = 0

dfs(0)
print(MAX)