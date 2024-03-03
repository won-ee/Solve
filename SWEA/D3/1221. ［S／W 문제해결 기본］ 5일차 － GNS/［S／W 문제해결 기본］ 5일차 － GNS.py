T = int(input())
for t in range(1,T+1):
    N = list(map(str,input().split()))
    arr = list(input().split())
    lst = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
    bucket = [0]*10
    arr_len = int(N[1])

    for i in range(arr_len) :
        for j in range(10):
            if arr[i] == lst[j] :
                bucket[j] += 1
    print(N[0])
    for i in range(10):
        if bucket[i] !=0:
            for j in range(bucket[i]):
                print(lst[i],end=' ')