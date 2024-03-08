a = list(input())
s = ''

for i in a:
    if i.isalpha():
        if 78<=ord(i)<=90 or 110<=ord(i)<=122:
            s+=chr(ord(i)-13)
        else:
            s+=chr(ord(i)+13)
    else:
        s+=i
print(s)