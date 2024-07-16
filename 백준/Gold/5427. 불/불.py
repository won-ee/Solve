from heapq import heappop,heappush

# 카운트, 불인지사람인지, dy,dx
def bfs(ny,nx):
    heap = []
    heappush(heap,(1,1,ny,nx))
    for fire_y,fir_x in fire:
        heappush(heap,(1,0,fire_y,fir_x))
    while heap:
        cnt,k,y,x = heappop(heap)
        for i in range(4):
            dy = diy[i] + y
            dx = dix[i] + x
            if k == 1:
                if dy<0 or dy>=h or dx<0 or dx>=w:
                    return cnt
            if dy < 0 or dy >= h or dx < 0 or dx >= w:
                continue
            if used[dy][dx] == 1:
                continue
            if arr[dy][dx] == '#':
                continue
            used[dy][dx] = 1
            heappush(heap,(cnt+1,k,dy,dx))

    return 'IMPOSSIBLE'


T = int(input())
for _ in range(T):
    w,h = map(int, input().split())
    arr = [list(input()) for _ in range(h)]
    diy = [0,0,-1,1]
    dix = [1,-1,0,0]
    used = [[0]*w for _ in range(h)]
    fire = []
    sty,stx = 0,0
    for i in range(h):
        for j in range(w):
            if arr[i][j] == '@':
                sty,stx = i,j
                used[i][j] = 1
            if arr[i][j] == '*':
                used[i][j] = 1
                fire.append((i,j))

    print(bfs(sty,stx))
