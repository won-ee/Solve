a = list(input())
bucket = [0]*125

for i in a:
    if ord(i)>=97:
        bucket[ord(i)-32] += 1
    else:
        bucket[ord(i)] += 1

if bucket.count(max(bucket))>1:
    print('?')
else:
    print(chr(bucket.index(max(bucket))))