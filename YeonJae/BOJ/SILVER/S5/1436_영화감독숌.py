import sys
input=sys.stdin.readline

n=int(input())
temp,count=0,0 #temp=0부터 1씩 증가 

while count<=n: #n이나오기 전까지 666찾기 
    temp+=1
    if '666' in str(temp):
        count+=1
    if count==n:
        print(temp)
        break
