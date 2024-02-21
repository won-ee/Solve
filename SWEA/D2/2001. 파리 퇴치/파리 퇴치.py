T = int(input())
for t in range(1, T + 1):
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]


    def pari(y, x):
        diy = []
        dix = []
        for i in range(M):
            diy.append(i)
            dix.append(i)
        diy *= M
        dix *= M
        dix.sort()

        ans = 0
        for i in range(len(diy)):
            dy = y + diy[i]
            dx = x + dix[i]
            if dx < 0 and dx > N and dy < 0 or dy > N:
                continue
            ans += arr[dy][dx]

        return ans


    MAX = 0
    for i in range(N - M + 1):
        for j in range(N - M + 1):
            ret = pari(i, j)
            if ret > MAX:
                MAX = ret

    print(f'#{t} {MAX}')