import heapq
import sys
#import numpy as np
input = sys.stdin.readline
MAX = 500
INF = 21e8


def set_game_zone(num, type):
    if num == 0:
        return
    for i in range(num):
        x, y, x1, y1 = map(int, input().split())
        start_x = min(x, x1)
        start_y = min(y, y1)
        end_x = max(x, x1)
        end_y = max(y, y1)
        for j in range(start_x, end_x + 1):
            for k in range(start_y, end_y + 1):
                game_zone[j][k] = type
    game_zone[0][0] = 0
    return


def Dijkstra():
    q = []
    heapq.heappush(q, (0, (0, 0)))
    distance[0][0] = 0
    while q:
        dist, now = heapq.heappop(q)
        x = now[0]
        y = now[1]
        if dist >= INF:
            continue
        if x == MAX and y == MAX:
            return distance[-1][-1]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx > MAX or ny > MAX or visited[nx][ny]:
                continue
            distance[nx][ny] = min(distance[nx][ny], distance[x][y] + game_zone[nx][ny])
            heapq.heappush(q, (distance[nx][ny], (nx, ny)))
            visited[nx][ny] = True
    return -1


game_zone = [[0 for _ in range(MAX + 1)] for _ in range(MAX + 1)]
visited = [[False for _ in range(MAX + 1)] for _ in range(MAX + 1)]
distance = [[INF for _ in range(MAX + 1)] for _ in range(MAX + 1)]

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

N = int(input())
set_game_zone(N, 1)
M = int(input())
set_game_zone(M, INF)

print(Dijkstra())
#print("distance = ")
#print(np.array(distance))

