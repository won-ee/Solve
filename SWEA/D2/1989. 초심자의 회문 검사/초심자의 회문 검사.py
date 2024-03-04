T = int(input())
for t in range(1,T+1):
    a = input()
    b = a[::-1]
    if a == b:
        print(f'#{t} {1}')
    else:
        print(f'#{t} {0}')