n, k = map(int,input().split())
coin=[]
for _ in range(n):
    x = int(input())
    if x <= k:
        coin.append(x)

coin.reverse()
cnt = 0
result = []

for i in coin:
    cnt += k // i
    k = k % i
    if k % i == 0:
        result.append(cnt)

print(min(result))