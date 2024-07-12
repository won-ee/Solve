N,L = map(int,input().split())
arr = list(map(int,input().split()))
ans = flag = 0
arr.sort()

for i in range(N):
    if flag == 0:
        flag = arr[i] + L
        ans += 1
    elif arr[i] < flag:
        continue
    else:
        flag = arr[i] + L
        ans += 1

print(ans)