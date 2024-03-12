N, K = map(int,input().split())
arr = [i for i in range(1, N + 1)]
ans =[0]*(N)
cnt = K-1
for i in range(N):
    if cnt >= len(arr):
        cnt = cnt%len(arr)
    ans[i] = arr.pop(cnt)
    cnt += K-1
result = str(ans).replace('[','<').replace(']','>')
print(result)