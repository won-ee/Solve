T = int(input())
for test_case in range(1, T + 1):
    arr = []

    def SUM(a, b):
        global ans
        for i in range(len(arr)):
            if arr[i][0]>a and arr[i][1]<b:
                ans+=1
            elif arr[i][0]<a and arr[i][1]>b:
                ans+=1

    n = int(input())
    ans = 0
    for i in range(n):
        aa,bb =map(int,input().split())
        if i>0:
            SUM(aa,bb)
        arr.append([aa,bb])

    print(f'#{test_case} {ans}')