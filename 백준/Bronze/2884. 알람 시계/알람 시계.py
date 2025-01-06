H, M = map(int,input().split())

x = H * 60 + M
x -= 45

h = x//60
m = x % 60
if h<0 :
    h += 24

print(h,m)