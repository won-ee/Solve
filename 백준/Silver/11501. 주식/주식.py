T= int(input())
for _ in range(T):
    N = int(input())
    arr = list(map(int,input().split()))
    ans = 0
    cnt = arr[N-1]
    for i in range(N-2,-1,-1):
        if arr[i]>cnt:
            cnt = arr[i]
        else:
            ans += cnt-arr[i]
    print(ans)