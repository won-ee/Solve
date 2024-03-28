A = input()
b = list(input())
n = len(b)
stack = []

for a in A:
    stack.append(a)
    if stack[-n:] == b :
        for i in range(n):
            stack.pop()
if len(stack) == 0:
    print('FRULA')
else:
    print(*stack,sep='')
