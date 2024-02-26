from collections import deque
N,M = map(int,input().split())
arr = [list(map(int,input())) for _ in range(N)]
diy = [0,0,1,-1]
dix = [1,-1,0,0]

q = deque()
q.append([0,0,1])
arr[0][0] = 0
while q:
    nowy,nowx,cnt = q.popleft()

    for i in range(4):
        dy = diy[i] + nowy
        dx = dix[i] + nowx
        if dy<0 or dx<0 or dy>=N or dx>=M:
            continue
        if arr[dy][dx] == 0 :
            continue
        if dy == N - 1 and dx == M - 1:
            print(cnt+1)
            exit()
        arr[dy][dx] = 0
        q.append([dy,dx,cnt+1])

