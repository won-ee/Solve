T = int(input())
for t in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input()))
    bucket = [0] * 10
    MAX = bucket[0]
    N_MAX = 0
    for i in range(N):
        bucket[arr[i]] += 1

    for i in range(10):
        if bucket[i] >= MAX:
            MAX = bucket[i]
            N_MAX = i
    print(f'#{t} {N_MAX} {MAX}')