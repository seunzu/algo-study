n,m=map(int,input().split())

visited=[False]*(n+1)
result=[]

def backtrack():
    if len(result)==m:
        print(*result)
        return 
    for i in range(1,n+1):
        if not visited[i]:
            visited[i]=True
            result.append(i)
            backtrack()
            result.pop()
            visited[i]=False
backtrack()