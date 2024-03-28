n = int(input())
br = input()
a = len(br)-1
b,r = 0,0
flag = 0
for i in range(n-2,-1,-1):
    if br[i] != br[-1]:
        flag = 1
    if flag:
        if br[i] == br[-1]:
             b+= 1
        else:
            r +=1

print(min(b,r))