T = int(input())
for _ in range(T):
    N = int(input())
    dp = [0] * (N + 1)
    dp[1] = 1
    for i in range(N+1):
        if i == 2: dp[i] = 2
        if i == 3: dp[i] = 4
        if i > 3 :
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    print(dp[N])
