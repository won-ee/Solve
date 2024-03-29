from collections import deque

arr = list(input())
stack = deque()

N = int(input())
for i in range(N):
    ar = input().split()
    if ar[0] == 'L' and arr:
        stack.appendleft((arr.pop()))
    if ar[0] == 'D' and stack:
        arr.append(stack.popleft())
    if ar[0] == 'B' and arr:
        arr.pop()
    if ar[0] == 'P':
        arr.append(ar[1])


for i in arr:
    print(i,end='')
for i in stack:
    print(i,end='')