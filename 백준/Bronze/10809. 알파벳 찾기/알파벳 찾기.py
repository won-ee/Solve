a = list(input())
arr = [-1]*26
for i in range(len(a)):
    if  arr[ord(a[i])-97] == -1:
        arr[ord(a[i])-97] = i
    else:
        continue

print(*arr)
