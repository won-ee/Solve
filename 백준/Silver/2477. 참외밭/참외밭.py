N = int(input())
arr = []
max_y,max_x = 0,0
max_y_index,max_x_index = 0,0


for i in range(6):
    a,b = map(int,input().split())
    if a == 1 or a == 2:
        if max_y<b:
            max_y =b
            max_y_index = i
    else:
        if max_x <b:
            max_x = b
            max_x_index = i
    arr.append((a,b))
index_list = [arr[max_y_index - 1], arr[(max_y_index + 1) % 6], arr[max_x_index - 1],
              arr[(max_x_index + 1) % 6]]


ans = 1
for i in arr:
    if i not in index_list:
        ans *=i[1]
print(N*(max_y*max_x-ans))


