N,M = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(N)]
K = int(input())
for _ in range(K):
    I,J,X,Y = map(int,input().split())
    ans = 0
    for i in range(I-1,X):
        for j in range(J-1,Y):
            ans += arr[i][j]
    print(ans)