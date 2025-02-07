n=int(input())
board=[[0]*100 for _ in range(100)] #100x100도화지로 초기화 
for i in range(n):
    x,y=map(int,input().split())
    for i in range(x,x+10):
        for j in range(y,y+10):
            board[i][j]=1
area=sum(sum(row) for row in board)
print(area)

