from collections import deque

def bfs(ny,nx,k):
    global ans,flag
    q = deque()
    q.append((ny,nx,1))
    temp = [(ny,nx)]
    while q:
        y,x,cnt = q.popleft()
        for diy,dix in di:
            dy,dx = y+diy,x+dix
            if 0<=dy<12 and 0<=dx<6:
                if used[dy][dx] == 0 and board[dy][dx] == k:
                    used[dy][dx] = 1
                    temp.append((dy,dx))
                    q.append((dy,dx,cnt+1))

    if len(temp) >=4:
        arr.append(temp)

board = [list(input()) for _ in range(12)]
di = [(1,0),(0,1),(-1,0),(0,-1)]
ans = 0
flag = 1
arr = []

while flag:
    used = [[0] * 6 for _ in range(12)]
    for i in range(12):
        for j in range(6):
            if board[i][j] != '.' and used[i][j] == 0:
                used[i][j] = 1
                bfs(i,j,board[i][j])

    if len(arr)>0:
        for ar in arr:
            for y,x in ar:
                board[y][x] = '.'
        ans += 1
        arr = []
    else:
        break

    for x in range(6):
        for y in range(10, -1, -1):
            for next_y in range(11, y, -1):
                if board[y][x] !='.' and  board[next_y][x] == ".":
                    board[next_y][x] = board[y][x]
                    board[y][x] = "."

print(ans)

