arr = list(map(int,input()))
bucket =[0]*10
for i in arr:
    bucket[i] += 1
a = bucket[6]+bucket[9]
bucket[6],bucket[9] = 0,0
if a%2 == 0:
    b = a//2
else:
    b = a//2+1
if  b>max(bucket):
    print(b)
else:
    print(max(bucket))