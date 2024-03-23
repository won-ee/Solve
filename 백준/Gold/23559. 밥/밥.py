n,money = map(int,input().split())
money -= (n*1000)
arr = [list(map(int, input().split())) for _ in range(n)]
arr.sort(key=lambda x: (x[0] - x[1]), reverse=True)
ans = 0
for i in arr:
    ans += i[1]

for i in arr:
    if money >= 4000 and i[0] > i[1]:
        ans += i[0] - i[1]
        money -= 4000
    else:
        break
print(ans)