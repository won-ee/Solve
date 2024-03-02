N = int(input())
MAX = MAX_I = MAX_M = 0
used = [0]*1001

for i in range(N):
    L,M = map(int,input().split())
    if MAX < M:
        MAX = M
        MAX_L = L
    used[L] = M

MAX = 0
for i in range(MAX_L):
    if used[i]>=MAX:
        MAX = used[i]
    used[i] = MAX

MAX = 0
for i in range(1000,MAX_L-1,-1):
    if used[i]>=MAX:
        MAX = used[i]
    used[i] = MAX

print(sum(used))