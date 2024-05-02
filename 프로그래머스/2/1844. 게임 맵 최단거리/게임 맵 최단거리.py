from collections import deque

def solution(maps):
    answer = -1
    N = len(maps)
    M = len(maps[0])
    di = [(0, 1), (1, 0), (-1, 0), (0, -1)]
    used =[[0]*M for _ in range(N)]
    q = deque()
    q.append((0, 0, 1))
    used[0][0] = 1
    while q:
        y, x, cnt = q.popleft()
        if y == N - 1 and x == M - 1:
            answer = cnt
            break

        for i in range(4):
            dy = di[i][0] + y
            dx = di[i][1] + x
            if dy < 0 or dy >= N or dx < 0 or dx >= M:
                continue
            if maps[dy][dx] == 0: continue
            if used[dy][dx] == 1: continue
            used[dy][dx]= 1
            q.append((dy, dx, cnt + 1))

    return answer
maps = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]

print(solution(maps))