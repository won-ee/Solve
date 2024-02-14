a = int(input())
for w in range(a):
    b = int(input())
    arr = list(map(int,input().split()))
    print(f'#{w+1} {max(arr)-min(arr)}')