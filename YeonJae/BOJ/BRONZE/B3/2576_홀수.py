n=[]
for i in range(7):
    num=int(input())
    if num%2!=0:
        n.append(num)
if n:
    n1=sorted(n)    
    print(sum(n1))
    print(min(n1))
else: print(-1)