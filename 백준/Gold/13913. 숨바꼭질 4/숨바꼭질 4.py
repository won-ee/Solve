from collections import deque


def path_print(x):
    arr = []
    temp = x
    for _ in range(path[x] + 1):
        arr.append(temp)
        temp = visited[temp]
    arr.reverse()
    print(*arr)


N,M = map(int,input().split())
visited = [0] * 100001
path = [0] * 100001
q = deque()
q.append(N)
while q:
    subin = q.popleft()
    if subin == M:
        print(path[subin])
        path_print(subin)
        exit()
    for i in (subin+1,subin-1,subin*2):
        if 0<=i<=100000 and path[i] == 0:
            path[i] = path[subin] +1
            visited[i] = subin
            q.append(i)
