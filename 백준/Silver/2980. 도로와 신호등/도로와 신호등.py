N,L = map(int,input().split())
arr = [0]*(L+1)
for i in range(N):
    D,R,G = map(int,input().split())
    arr[D] = [R,G]

cnt = 1
for i in range(1,L+1):
    if arr[i] == 0:
        arr[i] = cnt
        cnt += 1
        continue
    else:
        cnt+=1
        if cnt%(arr[i][0]+arr[i][1]) < arr[i][0]:
            cnt += arr[i][0] - cnt%(arr[i][0]+arr[i][1])

print(cnt)
