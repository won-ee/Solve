L= int(input())
N = int(input())
arr = [list(map(int,input().split())) for _ in range(N)]
Lst = [0]*(L+1)
a = b = -21e8

for i in range(N):
    for j in range(arr[i][0],arr[i][1]+1):
        if Lst[j] == 0:
            Lst[j] = i+1
    if (arr[i][1] - arr[i][0]) == b:
        continue
    elif (arr[i][1] - arr[i][0])> b:
        b = (arr[i][1] - arr[i][0])
        a = i+1


bucket = [0] * (L+1)
for i in Lst:
    if i ==0:
        continue
    bucket[i] +=1

print(a)
print(bucket.index(max(bucket)))

