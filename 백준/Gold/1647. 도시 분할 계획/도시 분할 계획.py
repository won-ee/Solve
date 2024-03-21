def find_boss(x):
    if boss[x] != x:
        boss[x] = find_boss(boss[x])
    return boss[x]


def union(a,b):
    a,b = find_boss(a),find_boss(b)

    if a == b:
        return
    if a < b:
        boss[b] = a
    else:
        boss[a] = b

N, M = map(int, input().split())
arr = []
for _ in range(M):
    s,e,w = map(int, input().split())
    arr.append((s, e, w))
arr.sort(key=lambda x:x[2])

boss = [i for i in range(N + 1)]

sum_weight = 0
max_weight = 0
for s, e, w in arr:
    if find_boss(s) == find_boss(e):
        continue

    sum_weight += w
    max_weight = w
    union(s,e)

print(sum_weight-max_weight)