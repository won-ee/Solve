from collections import deque

N = int(input())
acc =[0] * (N+1)
arr = [()]

for i in range(1,N+1):
    a,b = map(int,input().split())
    arr.append((a,b))
    acc[a] += 1
    acc[b] += 1
used = [1] * (N+1)
q = deque()
for i in range(1,N+1):
    if acc[i] < 2:
        used[i]=0
        q.append(i)

while q:
    no_present = q.popleft()

    for present in arr[no_present]:
        acc[present] -= 1
        if acc[present] < 2:
            if used[present]:
                used[present] = 0
                q.append(present)

print(acc.count(2))
for i in range(1,N+1):
    if acc[i] == 2:
        print(i,end=' ')

