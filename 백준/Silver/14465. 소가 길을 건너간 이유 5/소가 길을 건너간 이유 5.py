N,K,B = map(int,input().split())
arr = [1]*(N+1)
for _ in range(B):
    a = int(input())
    arr[a] = 0
MIN = 21e8
ans = 0
for i in range(1,N+1):
    ans += arr[i]
    if i>K:
        ans -= arr[i-K]
        if K-ans < MIN:
            MIN = K-ans
    
print(MIN)