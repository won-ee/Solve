A, B, C = map(int,input().split())
used = [[0]*(B+1) for _ in range(A+1)]
ans = []
def dfs(a,b):
    if used[a][b] == 0:
        used[a][b] = 1
        c = C - a - b

        if a + b < B:
            dfs(0, a + b)
        else:
            dfs(a + b - B, B)
        if a + c < C:
            dfs(0, b)
        else:
            dfs(a + c - C, b)
        if b + a < A:
            dfs(b + a, 0)
        else:
            dfs(A, b + a - A)
        if b + c < C:
            dfs(a, 0)
        else:
            dfs(a, b + c - C)
        if a + c < A:
            dfs(a + c, b)
        else:
            dfs(A, b)
        if b + c < B:
            dfs(a, b + c)
        else:
            dfs(a, B)

dfs(0, 0)
for i in range(B, -1, -1):
    if used[0][i] == 1:
        ans.append(C-i)

print(*ans)

