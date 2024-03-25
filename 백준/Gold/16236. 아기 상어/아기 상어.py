from heapq import heappush,heappop

def bfs(ny,nx,shark,fish):
    global ans
    used = [[0] * N for _ in range(N)]
    heap = []
    heappush(heap,(0,ny,nx))
    used[ny][nx] = 1
    while heap:
        cnt,y,x = heappop(heap)
        if arr[y][x] != 0:
            if arr[y][x] < shark:
                fish += 1
                arr[y][x] = 0
                if fish == shark:
                    fish = 0
                    shark += 1
                ans += cnt
                bfs(y, x, shark, fish)

        for i in range(4):
            dy = diy[i] + y
            dx = dix[i] + x
            if dy<0 or dy>=N or dx<0 or dx>=N:
                continue
            if used[dy][dx] == 1:
                continue
            if arr[dy][dx] > shark:
                continue

            used[dy][dx] = 1
            heappush(heap,(cnt+1,dy,dx))


N = int(input())
arr = [list(map(int,input().split())) for _ in range(N)]
diy = [-1,0,0,1]
dix = [0,-1,1,0]
shark_x,shark_y = 0,0
ans = 0

for i in range(N):
    for j in range(N):
        if arr[i][j] == 9:
            shark_y,shark_x = i,j
            arr[i][j] = 0

bfs(shark_y,shark_x,2,0)
print(ans)