#dfs
def dfs_recursive(graph,start,visited=[]):
    visited.append(start)
    for node in graph[start]:
        if node not in visited:
            dfs_recursive(graph,node,visited)
    return visited

com=[]
#컴퓨터의 수 
n=int(input())
#직접 연결되어 있는 컴퓨터 쌍수 
connect=int(input())
#번호 쌍 주어짐
for i in range(connect):
    com.append(list(map(int,input().split())))
#그래프 초기화 
graph={i:[]for i in range(1,n+1)}

#그래프 구성 
for x,y in com:
    graph[x].append(y)
    graph[y].append(x)
    # DFS 수행
visited_nodes = dfs_recursive(graph, 1)

# 1번 컴퓨터를 제외한 감염된 컴퓨터 수
infected_computers_count = len(visited_nodes) - 1
print(infected_computers_count)