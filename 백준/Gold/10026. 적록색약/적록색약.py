def bfs(ny,nx,key):
    q = deque()
    q.append((ny,nx))
    while q:
        y,x = q.popleft()
        for i in range(4):
            dy = diy[i] + y
            dx = dix[i] + x
            if dy<0 or dy>=N or dx<0 or dx>=N:
                continue
            if used[dy][dx] == 1:
                continue
            if arr[dy][dx] == key:
                used[dy][dx] = 1
                q.append((dy,dx))

def bfs_b(ny,nx,key):
    ky = 'X'
    if key == 'R':
        ky = 'G'
    if key == 'G':
        ky = 'R'
    q = deque()
    q.append((ny,nx))
    while q:
        y,x = q.popleft()
        for i in range(4):
            dy = diy[i] + y
            dx = dix[i] + x
            if dy<0 or dy>=N or dx<0 or dx>=N:
                continue
            if used_b[dy][dx] == 1:
                continue
            if arr[dy][dx] == key or arr[dy][dx]==ky:
                used_b[dy][dx] = 1
                q.append((dy,dx))


from collections import deque
N = int(input())
arr = [list(input()) for _ in range(N)]
diy = [0,0,1,-1]
dix = [1,-1,0,0]
used = [[0]*N for _ in range(N)]
used_b = [[0]*N for _ in range(N)]

a,b=0,0
b_list = []
for i in range(N):
    for j in range(N):
        if used[i][j] == 0:
            used[i][j] = 1
            bfs(i,j,arr[i][j])
            a += 1

        if used_b[i][j] == 0:
            used_b[i][j] = 1
            bfs_b(i,j,arr[i][j])
            b += 1

print(a,b)
