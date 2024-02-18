T = int(input())
for t in range(1, T + 1):
    N = int(input())
    arr = [2, 3, 5, 7, 11]


    def so(a):
        M = N
        Dab = 0
        while 1:
            if M % a == 0:
                M = M / a
                Dab += 1
            else:
                break
        return Dab


    lst = []
    for i in arr:
        ret = so(i)
        lst.append(ret)

    print(f'#{t}', *lst)