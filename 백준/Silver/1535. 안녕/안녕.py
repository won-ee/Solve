def dfs(idx, joy, health):
    global ans, N, L, J
    if N == idx and health > 0:
        ans = max(ans, joy)
        return ans
    if health > 0:
        dfs(idx + 1, joy + J[idx], health - L[idx])
        dfs(idx + 1, joy, health)
    return ans



ans = 0
N = int(input().strip())
L = list(map(int, input().split()))
J = list(map(int, input().split()))

dfs(0, 0, 100)

print(ans)
