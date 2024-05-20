T = int(input())
for _ in range(T):
    N = int(input())
    arr = list(map(int,input().split()))
    arr.sort()
    ans = 0
    for i in range(2,N):
        ans = max(ans,abs(arr[i]-arr[i-2]))
    print(ans)
    