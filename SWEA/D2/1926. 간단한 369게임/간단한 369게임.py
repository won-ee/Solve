n = int(input())
for i in range(1,n+1):
    if '3' in list(str(i)) or '6' in list(str(i)) or '9' in list(str(i)):
        a = '-'
        a *= (list(str(i)).count('3') + list(str(i)).count('6') + list(str(i)).count('9'))
        print(a,end=' ')
        continue
    print(i,end=' ')