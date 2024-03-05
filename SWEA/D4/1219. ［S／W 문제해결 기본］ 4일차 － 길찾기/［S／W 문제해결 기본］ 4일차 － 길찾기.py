def dfs(now):
    used[now] = 1
    for i in range(100):
        if used[i] == 0 and arr[now][i] == 1:
            dfs(i)


for t in range(1, 11):
    N, M = map(int, input().split())
    lst = list(map(int, input().split()))
    used = [0 for _ in range(100)]
    arr = [[0 for _ in range(100)] for _ in range(100)]
    for i in range(0, len(lst) - 1, 2):
        arr[lst[i]][lst[i + 1]] = 1

    dfs(0)
    if used[99] == 1:
        print(f"#{t} 1")
    else:
        print(f"#{t} 0")