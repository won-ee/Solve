T = int(input())
for test_case in range(1, T + 1):
    N,M =map(int,input().split())
    arr = [list(map(int,input().split())) for _ in range(N)]
    diy = [0,0,1,-1,1,-1,-1,1]
    dix = [1,-1,0,0,1,-1,1,-1]

    ans =0
    for i in range(N):
        for j in range(M):
            SUM = 0
            for k in range(8):
                dy = diy[k] + i
                dx = dix[k] + j
                if dy<0 or dx<0 or dy>=N or dx>=M:
                    continue
                if arr[i][j]>arr[dy][dx]:
                    SUM+=1
            if SUM>=4:
                ans+=1
    print(f'#{test_case} {ans}')