T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    arr = [list(input()) for _ in range(N)]
    diy = [-2, -1, 1, 2]
    dix = [2, 1, -1, -2]
    dixy = [-1, - 2, 1, 2]
    flag = 0

    for i in range(N):
        SUM = 0
        SUM1 = 0
        for j in range(N):
            # 가로 검사
            if arr[j][i] == 'o':
                SUM += 1
                if SUM == 5:
                    flag = 1
                    break
            else:
                SUM = 0
            # 세로 검사
            if arr[i][j] == 'o':
                SUM1 += 1
                if SUM1 == 5:
                    flag = 1
                    break
            else:
                SUM1 = 0
                # 대각선 검사
            if arr[i][j] == 'o':
                SUM2 = 0
                SUM3 = 0
                for k in range(4):
                    dy = diy[k] + i
                    dx = dix[k] + j
                    dy2 = dixy[k] + i
                    dx2 = dixy[k] + j
                    if dy >= 0 and dx >= 0 and dy < N and dx < N:
                        if arr[dy][dx] == 'o':
                            SUM2 +=1
                    if dy2 >= 0 and dx2 >= 0 and dy2 < N and dx2 < N:
                        if arr[dy2][dx2] == 'o':
                            SUM3 +=1

                if SUM2 == 4 or SUM3 == 4:
                    flag = 1
                    break

    if flag:
        print(f'#{test_case} YES')
    else:
        print(f'#{test_case} NO')