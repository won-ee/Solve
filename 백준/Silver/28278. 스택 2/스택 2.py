import sys
input = sys.stdin.readline
N = int(input())
stack = []
for i in range(N):
    ar = list(map(int,input().split()))
    if ar[0] == 1:
        stack.append(ar[1])
    elif ar[0] == 2:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop())
    elif ar[0] == 3:
        print(len(stack))
    elif ar[0] == 4:
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    elif ar[0] == 5:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[len(stack)-1])