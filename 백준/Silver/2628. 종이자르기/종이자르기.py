N,M = map(int,input().split())
arr = [[0]*N for _ in range(M)]
n = int(input())
bucket = [0]*(10000)

for k in range(1,n+1):
    l,x = map(int,input().split())
    if l == 0:
        for i in range(x):
            for j in range(N):
                arr[i][j] += 100
    if l == 1:
        for i in range(M):
            for j in range(x):
                arr[i][j] += 1

for i in arr:
    for j in i:
        bucket[j] += 1

print(max(bucket))



