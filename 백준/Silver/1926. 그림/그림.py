from collections import deque
N,M = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]
diy = [0,0,1,-1]
dix = [1,-1,0,0]
max_picture = 0
picture = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            q = deque()
            q.append((i,j))
            arr[i][j] = 0
            cnt = 0
            picture += 1
            while q:
                y,x = q.popleft()
                cnt += 1
                for k in range(4):
                    dy = diy[k] + y
                    dx = dix[k] + x
                    if dy<0 or dy>=N or dx<0 or dx>=M:
                        continue
                    if arr[dy][dx] == 0:
                        continue
                    arr[dy][dx] = 0
                    q.append((dy,dx))
            if max_picture < cnt:
                max_picture = cnt
print(picture)
print(max_picture)