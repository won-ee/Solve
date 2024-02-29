king_move = ['R','L','B','T','RT','LT','RB','LB']
diy = [0,0,1,-1,-1,-1,1,1]
dix = [1,-1,0,0,1,-1,1,-1]
chess= [[0]*8 for _ in range(8)]
king,stone,N = input().split()
move = [input() for _ in range(int(N))]
king,stone = list(king),list(stone)
kingy,kingx = 0,0
stoney,stonex = 0,0
for _ in range(2):
    chess[8 - int(king[1])][ord(king[0])-65] = 1
    kingy,kingx = 8 - int(king[1]),ord(king[0])-65
    chess[8 - int(stone[1])][ord(stone[0])-65] = 2
    stoney,stonex = 8 - int(stone[1]),ord(stone[0])-65


for i in move:
    y = diy[king_move.index(i)]
    x = dix[king_move.index(i)]
    if 0<=kingy+y<8 and 0<=kingx+x<8:
        if chess[kingy+y][kingx+x] == 2:
            if 0<=stoney+y<8 and 0<=stonex+x<8:
                chess[stoney + y][stonex + x] = 2
                chess[stoney][stonex] = 0
                stoney, stonex = stoney + y, stonex + x
            else:
                continue
        chess[kingy+y][kingx+x] = 1
        chess[kingy][kingx] = 0
        kingy,kingx = kingy+y,kingx+x

print(chr(kingx+65)+str(8-kingy))
print(chr(stonex+65)+str(8-stoney))
