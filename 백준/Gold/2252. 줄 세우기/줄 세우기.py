import sys
from collections import deque

n,m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
table = [0]*(n+1)

for i in range(m):
    a,b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    table[b]+=1

q = deque()
for i in range(1,n+1):
    if table[i]==0:
        q.append(i)

while q:
    now = q.popleft()
    for i in graph[now]:
        table[i]-=1
        if table[i]==0:
            q.append(i)
    print(now,end=" ")