import sys
input = sys.stdin.readline

n, k = map(int, input().split())
costs = list(map(int, input().split()))

max_cost = 0
idx = 0

while idx + k <= n:
    check = min(costs[idx: idx+k])

    for i in range(k-1, -1, -1):
        if costs[idx + i] == check:
            idx += i + 1
            break
    if check > max_cost:
        max_cost = check

print(max_cost)