def check(y,x):
    global ans
    white = 0
    black = 0
    for i in range(8):
        for j in range(8):
            if board[i+y][j+x] != white_board[i][j]:
                white += 1
            if board[i+y][j+x] != black_board[i][j]:
                black += 1
    ans = min(ans,black,white)


n,m = map(int,input().split())
board = [list(input()) for _ in range(n)]
white_board = [['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
               ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
               ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
               ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
               ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
               ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
               ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
               ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W']]
black_board = [ ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
                ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
                ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
                ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
                ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B']]
ans = 21e8

for i in range(n-7):
    for j in range(m-7):
        check(i,j)
print(ans)