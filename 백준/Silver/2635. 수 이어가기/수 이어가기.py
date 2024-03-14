def dfs(m,n,cnt):
    global MAX,arr
    a = m-n
    lst.append(a)
    if a <0:
        if MAX<cnt:
            MAX = cnt
            arr = lst[:]
        return
    dfs(n,a,cnt+1)

N = int(input())
MAX = -21e8
arr = []

for i in range(1,N+1):
    lst = [N]
    lst.append(i)
    ret = dfs(N,i,1)

lst = []
for i in arr:
    if i >=0:
        lst.append(i)
print(len(lst))
print(*lst)
