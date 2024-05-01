N = int(input())
arr = []
mid = 0
for _ in range(N):
    a,b = map(int,input().split())
    arr.append((a,b))
    mid += b
arr.sort()

person = 0
for i,p in arr:
    person += p
    if person >= mid/2:
        print(i)
        break