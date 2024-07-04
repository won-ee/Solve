from collections import deque
N = int(input())
arr = list(map(int,input().split()))
arr.sort()
q = deque(arr)
ans = 0
if N%2 == 0:
    while q:
        ans = max(ans,q.pop()+q.popleft())
else:
    ans = q.pop()
    while q:
        ans = max(ans,q.pop()+q.popleft())
print(ans)