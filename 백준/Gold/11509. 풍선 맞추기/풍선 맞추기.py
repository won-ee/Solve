N = int(input())
arr = list(map(int,input().split()))
buket = [0]*1000001

for i in range(N):
    if buket[arr[i]] == 0:
        buket[arr[i]-1] += 1
    else:
        buket[arr[i]] -= 1
        buket[arr[i]-1] += 1

print(sum(buket))