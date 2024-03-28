import sys
n = int(input())
br = sys.stdin.readline().rstrip()
b,r = 0,0
flag = 0
for i in range(n-2,-1,-1):
    if br[i] != br[-1]:
        flag = 1
    if flag:
        if br[i] == br[-1]:
             b += 1
        else:
            r +=1
B,R = 0,0
flag = 0
for i in range(1,n):
    if br[i] != br[0]:
        flag = 1
    if flag:
        if br[i] == br[0]:
            B += 1
        else:
            R += 1

print(min(b,r,B,R))