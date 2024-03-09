def canto(num):
    lenn = num // 3
    if num == 1:
        return '-'
    else:
        return canto(lenn)+' '*lenn+canto(lenn)


while 1:
    try:
        n = int(input())
        a = 3 ** n
        print(canto(a))
    except:
        break