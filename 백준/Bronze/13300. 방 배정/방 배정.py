N, K = map(int,input().split())
arr = [0]*7
lst = [0]*7
cnt = 0
for _ in range(N):
    s,y = map(int,input().split())
    if s == 0:
        arr[y]+=1
        if arr[y] == K:
            cnt +=1
            arr[y] = 0
    else:
        lst[y] += 1
        if lst[y] == K:
            cnt += 1
            lst[y] = 0
for i in range(7):
    if arr[i] != 0 :
        cnt+=1
    if lst[i] != 0:
        cnt +=1

print(cnt)