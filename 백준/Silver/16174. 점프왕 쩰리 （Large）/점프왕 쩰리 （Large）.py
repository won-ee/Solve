from collections import deque
N = int(input())
arr = [list(map(int,input().split())) for _ in range(N)]
diy = [0,1]
dix = [1,0]
flag = 0

def bfs():
    global flag
    q = deque()
    q.append([0,0])
    while q:
        y,x = q.popleft()
        cnt = arr[y][x]
        arr[y][x] = 0
        if y == N-1 and x == N-1:
            flag = 1
            return

        for i in range(2):
            dy = diy[i]*cnt + y
            dx = dix[i]*cnt + x
            if dy >=N or dx>=N:
                continue
            if arr[dy][dx] == 0 :
                continue
            q.append([dy,dx])


bfs()

if flag:
    print('HaruHaru')
else:
    print('Hing')