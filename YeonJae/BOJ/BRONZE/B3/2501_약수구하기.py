import sys
input=sys.stdin.readline
num,n=map(int,input().split())
de=[]
for i in range (num):
    if num%(i+1)==0:
        de.append(i+1)
if len(de)<n:
    print(0)
else:
    print(de[n-1])
