def dfs(x, y, num):
    if len(num) == 6:
        ans.add(num)
        return

    for k in range(4):
        dx = x + dix[k]
        dy = y + diy[k]
        if 0 <= dx < 5 and 0 <= dy < 5:
            dfs(dx, dy, num + arr[dx][dy])

arr = [list(input().split()) for _ in range(5)]
dix = [1, -1, 0, 0]
diy = [0, 0, 1, -1]
ans = set()

for i in range(5):
    for j in range(5):
        dfs(i, j, arr[i][j])
print(len(ans))