m=int(input())
n=int(input())
s=[]
for i in range(m,n+1): 
    t=int(i**0.5)**2
    #제곱수라면
    if i==t:
        s.append(i) 

if s:
    print(sum(s))
    print(min(s))
else:
    print(-1)
