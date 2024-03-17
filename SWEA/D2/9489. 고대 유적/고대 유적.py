T = int(input())
for test_case in range(1, T + 1):
    N,M = map(int,input().split())
    arr = [list(map(int,input().split())) for _ in range(N)]
    MAX = -21e8
    for i in range(N):
        SUM = 0
        for j in range(M):
            if arr[i][j] ==1:
                SUM +=1
                if MAX<SUM:
                    MAX = SUM
            else:
                SUM = 0

        for i in range(M):
            SUM = 0
            for j in range(N):
                if arr[j][i] == 1:
                    SUM += 1
                    if MAX<SUM:
                        MAX =SUM
                else:
                    SUM = 0

    print(f'#{test_case} {MAX}')
