from collections import deque
q = deque(range(1,int(input())+1))

while q:
    if len(q) == 1:
        break
    q.popleft()
    a = q.popleft()
    q.append(a)
print(q[0])