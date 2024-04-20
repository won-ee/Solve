N,M = map(int,input().split())
arr = []
ret = [21e8]*(N+1)
ret[1] = 0

for i in range(M):
    a,b,c = map(int,input().split())
    arr.append((a,b,c))

for i in range(N):
    for j in range(M):
        now = arr[j][0]
        next = arr[j][1]
        price = arr[j][2]
        if ret[now] != 21e8 and ret[next] > ret[now]+price:
            ret[next] = ret[now] + price
            if i == N-1:
                print(-1)
                exit()

for i in range(2,N+1):
    if ret[i] == 21e8:
        print(-1)
    else:
        print(ret[i])