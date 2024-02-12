T = int(input())
for t in range(1, T + 1):
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]


    def di(y, x):
        Sum = 0
        diy = [0] * ((2 * arr[y][x]) + 1)
        dix = []
        for k in range(-arr[y][x], arr[y][x] + 1):
            diy.append(k)
            dix.append(k)
        dix += [0] * ((2 * arr[y][x]) + 1)

        for i in range(len(diy)):
            dy = diy[i] + y
            dx = dix[i] + x
            if 0 > dy or dy > N - 1 or 0 > dx or dx > M - 1:
                continue
            Sum += arr[dy][dx]

        return Sum - (arr[y][x])


    MAX = 0
    for i in range(N):
        for j in range(M):
            ret = di(i, j)
            if ret > MAX:
                MAX = ret
    print(f'#{t} {MAX}')