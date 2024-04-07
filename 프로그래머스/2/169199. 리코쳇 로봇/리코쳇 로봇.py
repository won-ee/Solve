from collections import deque

def solution(board):
    answer = -1
    len_y = len(board)
    len_x = len(board[0])
    end_y, end_x = 0, 0
    st_y, st_x = 0, 0
    for i in range(len_y):
        for j in range(len_x):
            if board[i][j] == 'G':
                end_y, end_x = i, j
            if board[i][j] == 'R':
                st_y, st_x = i, j

    diy = [0, 0, 1, -1]
    dix = [1, -1, 0, 0]
    used = [[0] * (len_x + 1) for _ in range(len_y + 1)]
    used[st_y][st_x] = 1
    q = deque()
    q.append((st_y, st_x, 0))
    test = []
    while q:
        y, x, cnt = q.popleft()
        if y == end_y and x == end_x:
            answer = cnt
            break

        for i in range(4):
            key = 1
            key_y, key_x = y, x
            while 1:
                dy = diy[i] * key + y
                dx = dix[i] * key + x
                if board[key_y][key_x] == 1:
                    continue
                if dy < 0 or dy >= len_y or dx < 0 or dx >= len_x:
                    if used[key_y][key_x] == 0:
                        used[key_y][key_x] = 1
                        q.append((key_y, key_x, cnt + 1))
                        break
                    break

                if board[dy][dx] == 'D':
                    if used[key_y][key_x] == 0:
                        used[key_y][key_x] = 1
                        q.append((key_y, key_x, cnt + 1))
                        break
                    break

                key += 1
                key_y, key_x = dy, dx
    return answer