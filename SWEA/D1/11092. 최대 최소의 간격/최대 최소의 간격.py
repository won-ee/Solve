ww = int(input())
for q in range(1,ww+1):
    n = int(input())
    arr = list(map(int, input().split()))

    a = arr.index(min(arr))
    arr.reverse()
    b = arr.index(max(arr))
    c = len(arr)-b-1

    print(f'#{q} {abs(c-a)}')