n = int(input())
for i in range(1,n+1):
    if '3' in list(str(i)) or '6' in list(str(i)) or '9' in list(str(i)):
        bak =0
        bak += list(str(i)).count('3')
        bak += list(str(i)).count('6')
        bak += list(str(i)).count('9')
        a = '-'*bak
        print(a,end=' ')
        continue
    print(i,end=' ')