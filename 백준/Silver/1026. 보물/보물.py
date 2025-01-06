N = int(input())
A = list(map(int,input().split()))
B = list(map(int,input().split()))
A.sort()
res = 0

for i in range(N):
    res += A[i] * B.pop(B.index(max(B)))
print(res)
