import sys
input = sys.stdin.readline

n = int(input())
arr = [0] + [int(input()) for _ in range(n)]

dp = [0] * (n+1)

dp[1] = arr[1]
if n == 1: print(dp[n])
else:
    dp[2] = arr[1] + arr[2]
    if n==2:print(dp[n])
    else:
        dp[3] = max(arr[1] + arr[3], arr[2] + arr[3])

        for i in range(2,n+1):
            dp[i] = max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i])

        print(dp[n])

