T,M = map(int,input().split())
N = int(input())
MI = M+N
while 1:
    if MI >= 60:
        T+=1
        MI-=60
        if T>= 24:
            T-= 24
    else:
        break


print(T, MI)