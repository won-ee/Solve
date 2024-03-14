import math
N = int(input())
A = list(map(int,input().split()))
B,C = map(int,input().split())

ans = 0
while A:
    a = A.pop()
    a-=B
    ans += 1
    if a<=0:
        continue
    ans += math.ceil(a/C)

print(ans)