N,K = map(int,input().split())
arr = list(map(int,input().split()))
lst = []
ans = 0
cnt = 0
for i in range(N):
    ans += arr[i]
    if i ==K-1:
        lst.append(ans)
    if i >= K:
        ans-=arr[cnt]
        cnt +=1
        lst.append(ans)

print(max(lst))