import sys
sys.setrecursionlimit(100000)
def dfs(x, y, graph, n, m):
    directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    count_p = 0
    stack = [(x, y)]

    while stack:
        x, y = stack.pop()

        if x < 0 or y < 0 or x >= n or y >= m or graph[x][y] == -1:
            continue

        if graph[x][y] == 'P':
            count_p += 1
        if graph[x][y] in {'I', 'O', 'P'}:
            graph[x][y] = -1
            for dx, dy in directions:
                stack.append((x + dx, y + dy))

    return count_p



input = sys.stdin.readline
n, m = map(int, input().split())
graph = [list(input().rstrip()) for _ in range(n)]

start_x, start_y = None, None
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'I':
            start_x, start_y = i, j
            break
    if start_x is not None:
        break

if start_x is None:
    print('TT')


count_p = dfs(start_x, start_y, graph, n, m)

print(count_p if count_p > 0 else 'TT')
