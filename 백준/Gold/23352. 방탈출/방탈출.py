from collections import deque

def bfs(ny, nx):
    q = deque()
    q.append((ny, nx, 0))
    used = [[0]*M for _ in range(N)]
    used[ny][nx] = 1


    while q:
        y, x, cnt = q.popleft()
        flag = False
        for diy, dix in di:
            dy, dx = y + diy, x + dix
            if dy < 0 or dy >= N or dx < 0 or dx >= M: continue
            if arr[dy][dx] == 0: continue
            if used[dy][dx] == 1: continue
            flag = True
            used[dy][dx] = 1
            q.append((dy, dx, cnt + 1))
        if not flag:
            answers.append((cnt, arr[ny][nx]+ arr[y][x]))



N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
di = [(0, 1), (0, -1), (1, 0), (-1, 0)]
answers = []

for i in range(N):
    for j in range(M):
        if arr[i][j] != 0:
            bfs(i, j)

answers.sort(key=lambda x: (x[0], x[1]), reverse=True)
print(answers[0][1])
