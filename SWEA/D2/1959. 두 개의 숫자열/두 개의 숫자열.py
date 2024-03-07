T = int(input())
for test_case in range(1, T + 1):
    n,m = map(int,input().split())
    arrn = list(map(int,input().split()))
    arrm = list(map(int,input().split()))

    if n>m:
        a = n
        b = m
        arra = arrn
        arrb = arrm
    else:
        a = m
        b = n
        arra = arrm
        arrb = arrn

    MAX = -21e8

    for i in range(a-b+1):
        gob = 0
        for j in range(b):
            gob += arra[j+i]*arrb[j]
        if MAX<gob:
            MAX = gob

    print(f'#{test_case} {MAX}')
