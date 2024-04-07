from collections import deque

def solution(maps):
    sty,syx,edy,edx,lx,ly=0,0,0,0,0,0
    len_y,len_x= len(maps),len(maps[0])
    for i in range(len_y):
        for j in range(len_x):
            if maps[i][j] == 'S':
                sty,stx = i,j
            if maps[i][j] == 'E':
                edy,edx = i,j
            if maps[i][j] == 'L':
                ly,lx = i,j
    
    answer =  bfs(sty,stx,ly,lx,0,maps,edy,edx)  

    return  answer


def bfs(ny,nx,ey,ex,count,arr,real_edy,real_edx):
    len_y,len_x= len(arr),len(arr[0])
    used = [[0]*len_x for _ in range(len_y)]
    diy = [0,0,1,-1]
    dix = [1,-1,0,0]
    q = deque()
    q.append((ny,nx,count))
    used[ny][nx] = 1
    while q:
        y,x,cnt = q.popleft()

        if y == ey and x == ex :
            if y != real_edy or x !=  real_edx:
                ret = bfs(y,x,real_edy,real_edx,cnt,arr,real_edy,real_edx)
                return ret
            elif y == real_edy and x == real_edx:
                return cnt
                
        for i in range(4):
            dy = diy[i] + y
            dx = dix[i] + x
            if dy<0 or dy>=len_y or dx<0 or dx>=len_x:
                continue
            if used[dy][dx] == 1:
                continue
            if arr[dy][dx] == 'X':
                continue
            used[dy][dx] = 1
            q.append((dy,dx,cnt+1))
            
    return -1