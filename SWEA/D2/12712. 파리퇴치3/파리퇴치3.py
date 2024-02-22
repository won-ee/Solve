T = int(input())
for t in range(1,T+1):
    def di(y,x):
        SUM = -arr[y][x]
        for i in range(len(dix)):
            dy = diy[i]+ y
            dx = dix[i] +x
            if dy<0 or dx<0 or dy>=n or dx>=n:
                continue
            SUM += arr[dy][dx]

        SUM2 = -arr[y][x]
        for i in range(len(dix2)):
            dy2 = diy2[i] + y
            dx2 = dix2[i] + x
            if dy2 < 0 or dx2 < 0 or dy2 >= n or dx2 >= n:
                continue
            SUM2 += arr[dy2][dx2]
        if SUM> SUM2:
            return SUM
        else:
            return SUM2

    n,m = map(int,input().split())
    arr = [list(map(int,input().split())) for _ in range(n)]
    diy,dix = [],[]
    diy2,dix2 = [],[]
    lst = []
    MAX = -21e8

    for i in range(m-1,-m,-1):
        dix.append(i)
        diy2.append(0)
        lst.append(0)


    for i in range(-m+1,m):
        dix.append(i)
        diy.append(i)
        diy2.append(i)
        dix2.append(i)

    diy *= 2
    dix2 +=lst

    for i in range(n):
        for j in range(n):
            ret = di(i,j)
            if ret>MAX:
                MAX = ret


    print(f'#{t} {MAX}')
