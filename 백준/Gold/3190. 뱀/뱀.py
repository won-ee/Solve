from collections import deque
N = int(input())
K = int(input())
arr = [[0]*N for _ in range(N)]
for _ in range(K):
    y,x = map(int,input().split())
    arr[y-1][x-1] = 2
L = int(input())
move_list = deque()
for _ in range(L):
    x, c = input().split()
    move_list.append((int(x),c))

snake = deque()
snake.append((0,0))
di  = [(0,1),(1,0),(0,-1),(-1,0)]
move_di = 0
cnt = 0

while 1:
    cnt += 1
    y,x = snake[0][0],snake[0][1]
    dy = di[move_di][0] + y
    dx = di[move_di][1] + x
    if (dy,dx) in snake:
        break
    if dy<0 or dy>=N or dx<0 or dx>=N:
        break
    if arr[dy][dx] == 0:
        snake.pop()
    else:
        arr[dy][dx] = 0
    snake.appendleft((dy,dx))

    if len(move_list) == 0:
        continue
    if cnt == move_list[0][0]:
        move,turn = move_list.popleft()
        if turn == 'D':
            move_di = (move_di + 1) % 4
        if turn == 'L':
            move_di = (move_di - 1) % 4

print(cnt)