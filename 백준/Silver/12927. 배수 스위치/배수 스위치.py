swich =[''] + list(input())

cnt = 0
for i in range(1,len(swich)):
    if swich.count('N') == len(swich):
        break
    if swich[i] == 'Y':
        for j in range(i,len(swich),i):
            if swich[j] == 'Y':
                swich[j] = 'N'
            else:
                swich[j] = 'Y'
        cnt+=1

if swich.count('N') == len(swich)-1:
    print(cnt)
else:
    print(-1)