arr = [[0]*101 for _ in range(101)]
ans = 0
for _ in range(4):
    a,b,c,d = map(int,input().split())
    if a <c :
        a,c=c,a
    if b<d:
        b,d = d,b
    for i in range(c,a):
        for j in range(d,b):
            if arr[i][j] == 0:
                arr[i][j]+=1
                ans+=1
print(ans)



