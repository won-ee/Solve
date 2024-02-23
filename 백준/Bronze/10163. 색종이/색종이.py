n = int(input())
arr= [['_']*1001 for _ in range(1001)]
lst = [0]*n
for k in range(n):
    a,b,c,d = map(int,input().split())
    for i in range(a,c+a):
        for j in range(b,d+b):
            arr[i][j] = k

for i in arr :
    for j in i:
        if j !='_':
            lst[j]+=1

for i in lst:
    print(i)