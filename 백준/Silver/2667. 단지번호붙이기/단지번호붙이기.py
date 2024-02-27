from collections import deque
N = int(input())
arr = [list(map(int,input())) for _ in range(N)]
apart = 0
diy = [0,0,1,-1]
dix = [1,-1,0,0]
lst = []

def bfs(sty,stx):
    global arr,apart
    q = deque()
    q.append([sty,stx])
    cnt= 0
    while q:
        y,x = q.popleft()
        cnt +=1
        for i in range(4):
            dy = diy[i] + y
            dx = dix[i] + x
            if dy<0 or dx<0 or dy>=N or dx>=N:
                continue
            if arr[dy][dx] == 0:
                continue
            arr[dy][dx] = 0
            q.append([dy,dx])
    lst.append(cnt)

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            arr[i][j] = 0
            bfs(i,j)
            apart += 1
print(apart)
lst.sort()
for i in lst:
    print(i)
