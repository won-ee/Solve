from heapq import heappop,heappush


def bfs(ny,nx):
    used = [[[0]*4 for _ in range(N)] for _ in range(N)]
    heap = []

    for i in range(4):
        heappush(heap,(0,ny,nx,i))
        used[ny][nx][i] = 1

    while heap:
        cnt,y,x,d = heappop(heap)
        dy,dx = y+di[d][0],x+di[d][1]
        if 0<=dy<N and 0<=dx<N:
            if arr[dy][dx] == '*':continue
            if used[dy][dx][d] == 1:continue
            if arr[dy][dx] == '#':
                print(cnt)
                exit()
            if arr[dy][dx] == '!':
                if d <2 :
                    for nd in range(2,4):
                        heappush(heap,(cnt+1,dy,dx,nd))
                else:
                    for nd in range(2):
                        heappush(heap,(cnt+1,dy,dx,nd))

            used[dy][dx][d] = 1
            heappush(heap,(cnt,dy,dx,d))



N = int(input())
arr = [list(input()) for _ in range(N)]
di=[(1,0),(-1,0),(0,-1),(0,1)]

for i in range(N):
    for j in range(N):
        if arr[i][j] == '#':
            bfs(i,j)