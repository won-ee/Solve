T = int(input())
for _ in range(T):
    N = int(input())
    arr = [list(map(int,input().split())) for _ in range(N)]
    arr.sort()

    ans = 1
    flag = arr[0][1]
    for i in range(1, N):
        if flag > arr[i][1]:
            ans += 1
            flag = arr[i][1]

    print(ans)