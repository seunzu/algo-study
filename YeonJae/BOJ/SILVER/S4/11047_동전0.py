import sys
coin_types=[]
cnt=0
n,k=list(map(int,input().split()))
for i in range(n):
    coin_types.append(int(input()))
coin_types=sorted(coin_types,reverse=True)

for j in coin_types:
    cnt+=k//j
    k%=j

print(cnt)