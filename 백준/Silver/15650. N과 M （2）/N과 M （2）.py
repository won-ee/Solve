def seq(lv,now):
    if lv == M:
        copy = path[:]
        ans.append(copy)
        return
    for i in range(now,N+1):
        # print(i,path)
        path[lv] = i
        seq(lv+1,i+1)

N,M = map(int,input().split())
ans = []
path = [0]*M
seq(0,1)
ans.sort()

for i in ans:
    for j in i:
        print(j,end=' ')
    print()