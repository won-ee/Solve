for t in range(1,11):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    x = arr[99].index(2)
    y = 99

    while 1:

        if y == 0:
            print(f'#{N} {x}')
            break

        dx = x-1
        if 0 <= dx < 100:
            if arr[y][dx] == 1:
                arr[y][x] = 0
                x = dx
                continue

        dx = x+1
        if 0 <= dx < 100:
            if arr[y][dx] == 1:
                arr[y][x] = 0
                x = dx
                continue
        y -= 1