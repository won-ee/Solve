N, L = map(int,input().split())
lst = []

for i in range(1,(N+1)*10):
    if str(L) in list(str(i)):
        continue
    lst.append(i)
    if len(lst) == N:
        break

print(lst[len(lst)-1])
